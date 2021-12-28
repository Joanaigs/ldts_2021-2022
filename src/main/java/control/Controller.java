package control;

import model.GameModel;
import view.ElementsView.GameView;

import java.io.IOException;

public class Controller {
    GameModel gameModel;
    GameView gameView;
    Thread thread;
    ReadKeys readKeys;
    MenuController menuController;

    public Controller() throws IOException {
        readKeys =  new ReadKeys();
        thread = new Thread(readKeys);
        // chamar construtor do menu controler, o do pacman fica só no run game, e tens de ser tu a chamá-la.
        menuController = new MenuController();
    }

    public void run() throws IOException, InterruptedException {
        // screenViewer.setViewer(menuViewer);
        thread.start(); // começa a ler as keys
        //tens de tratar do menu aqui. Chamar o menu aqui, da mesma maneira que eu chamo o meu jogo (gameView.draw() em baixo)
        // quando se clicar em play tens de chamar o meu run game
        runGame();
    }


    public void runGame() throws IOException, InterruptedException {
        gameModel = new GameModel();
        PacmanController pacmanController = new PacmanController(gameModel.getMap().getPacman());
        gameView = new GameView(gameModel);


        readKeys.setScreen(gameView.getScreen());
        readKeys.addObserver(pacmanController);


        long pastTime = System.currentTimeMillis();     // para poder ter o tempo de frame em frame
        while(gameModel.isRunning()){
            long now = System.currentTimeMillis();
            gameModel.update(now-pastTime);
            gameView.draw();
            pastTime = now;
        }
        readKeys.removeObserver(pacmanController);
    }

}
