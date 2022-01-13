package g0902.states;

import g0902.control.Observer;
import g0902.control.PacmanController;
import g0902.gui.LanternaGUI;
import g0902.model.Game.GameModel;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Model;
import g0902.view.ElementsView.GameView;
import g0902.view.Viewer;

import java.io.IOException;

public class GameState extends State{
    private GameView gameView;
    private GameModel gameModel;
    private PacmanController pacmanController;
    private long totalTime, pastTime;
    public static final long TIME_FIXED = 20;
    LanternaGUI gui;

    private void initializing() throws IOException {
        gameModel = new GameModel();
        pacmanController = new PacmanController(gameModel.getMap().getPacman());
        totalTime = 0;
        pastTime = System.currentTimeMillis();
        gui=new LanternaGUI();
        gui.createScreenGame();
    }

    public GameState() throws IOException {
        super();
        initializing();
        gameView = new GameView(gameModel, gui.getScreen());
    }

    public GameState(GameView view) throws IOException {
        super();
        initializing();
        gameView=view;
    }

    @Override
    public Viewer getViewer() {
        return gameView;
    }

    @Override
    public Observer getObserver(){
        return pacmanController;
    }

    @Override
    public Model getModel() {
        return gameModel;
    }

    @Override
    public boolean isRunning() {
        return gameModel.isRunning();
    }

    @Override
    public String getString() {
        return "Game";
    }

    @Override
    public void setViewer(Viewer viewer) {this.gameView= (GameView) viewer;}

    @Override
    public void step() throws IOException {
        long now = System.currentTimeMillis();
        totalTime += now-pastTime;
        while(totalTime >= TIME_FIXED) {
            gameModel.update(TIME_FIXED);
            totalTime-=TIME_FIXED;
        }
        gameModel.setScore(pacmanController.getPacman().getScore());
        gameView.draw();
        pastTime = now;
    }

    @Override
    public State nextState() throws IOException {
        boolean lost=gameModel.hasLost();
        int score = gameModel.getScore();
        EndScreenState state = new EndScreenState();
        ((EndScreenModel) state.getModel()).setScore(score);
        ((EndScreenModel) state.getModel()).setLost(lost);

        return state;
    }
}
