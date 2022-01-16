package g0902.states;

import g0902.control.InstructionMenuController;
import g0902.control.Observer;
import g0902.control.PacmanController;
import g0902.gui.LanternaGUI;
import g0902.model.Game.GameModel;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Menu.InstructionMenuModel;
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

    public GameState() throws IOException {
        super();
        gameModel = new GameModel("map");
        pacmanController = new PacmanController(gameModel.getMap().getPacman());
        totalTime = 0;
        pastTime = System.currentTimeMillis();
        gui=new LanternaGUI();
        gui.createScreenGame();
        gameView = new GameView(gameModel, gui.getScreen());
    }
    //for test use only
    public GameState(GameView view, GameModel model, PacmanController controller){
        super();
        gameModel=model;
        totalTime = 0;
        pastTime = System.currentTimeMillis();
        pacmanController=controller;
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

    public long getPastTime() {
        return pastTime;
    }

    public long getTotalTime() {
        return totalTime;
    }
}
