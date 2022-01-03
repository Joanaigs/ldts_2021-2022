package states;

import control.Controller;
import control.Observer;
import control.PacmanController;
import model.Elements.Pacman;
import model.GameModel;
import model.Model;
import view.ElementsView.GameView;
import view.Viewer;

import java.io.IOException;

public class GameState extends State{
    private GameView gameView;
    private GameModel gameModel;
    private long pastTime;
    private PacmanController pacmanController;
    public GameState(long pastTime) throws IOException {
        super();
        this.pastTime=pastTime;
        gameModel = new GameModel();
        pacmanController = new PacmanController(gameModel.getMap().getPacman());
        gameView=new GameView(gameModel);

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
        gameModel.update(now-pastTime);
        gameModel.setScore(pacmanController.getPacman().getScore());
        gameView.draw();
        pastTime = now;
    }
}
