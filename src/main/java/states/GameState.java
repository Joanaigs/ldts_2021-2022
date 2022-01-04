package states;

import control.Observer;
import control.PacmanController;
import model.GameModel;
import model.Model;
import view.ElementsView.GameView;
import view.Viewer;

import java.io.IOException;

public class GameState extends State{
    private GameView gameView;
    private GameModel gameModel;
    private PacmanController pacmanController;
    private long totalTime, pastTime;
    public static final long TIME_FIXED = 20;


    public GameState(long pastTime) throws IOException {
        super();
        this.pastTime=pastTime;
        gameModel = new GameModel();
        pacmanController = new PacmanController(gameModel.getMap().getPacman());
        gameView = new GameView(gameModel);
        totalTime = 0;
        pastTime = System.currentTimeMillis();

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
}
