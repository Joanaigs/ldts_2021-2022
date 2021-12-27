package control;

import model.GameModel;
import view.ElementsView.GameView;

import java.io.IOException;

public class Controller {

    GameModel gameModel;
    GameView gameView;

    public Controller() throws IOException {
        gameModel = new GameModel();
        gameView = new GameView(gameModel);
    }

    public void run() throws IOException, InterruptedException {
        long pastTime = System.currentTimeMillis();     // para poder ter o tempo de frame em frame
        while(true){
            long now = System.currentTimeMillis();
            gameView.draw();
            pastTime = now;
        }
        //readKeys.interrupt();
    }
}
