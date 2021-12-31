package control;

import model.GameModel;
import model.Menu.InstructionMenuModel;
import model.Menu.MainMenuModel;
import view.ElementsView.Ghosts.CyanView;
import view.ViewInstructionMenu;
import view.ViewMainMenu;

import java.io.IOException;

import static java.lang.System.exit;

public class Controller {
    GameModel gameModel;
    CyanView.GameView gameView;
    MainMenuModel mainMenuModel;
    ViewMainMenu viewMainMenu;
    InstructionMenuModel instructionMenuModel;
    ViewInstructionMenu viewInstructionMenu;
    Thread thread;
    ReadKeys readKeys;
    MenuController menuController;
    public static final long TIME_FIXED = 20;


    public Controller() throws IOException {
        readKeys =  new ReadKeys();
        thread = new Thread(readKeys);
        thread.start();
        // chamar construtor do menu controler, o do pacman fica só no run game, e tens de ser tu a chamá-la.
    }

    public void run() throws IOException, InterruptedException {
        mainMenuModel=new MainMenuModel();
        viewMainMenu = new ViewMainMenu(mainMenuModel);
        menuController = new MenuController(mainMenuModel);

        readKeys.setScreen(viewMainMenu.getScreen());
        readKeys.addObserver(menuController);


        while(mainMenuModel.isRunning()){
            viewMainMenu.draw();
        }

        readKeys.removeObserver(menuController);
        viewMainMenu.closeScreen();
        switch (mainMenuModel.getSelected()) {
            case "START":
                runGame();
                break;
            case "INSTRUCTIONS":
                runIntructionMenu();
                break;
            case "RANKINGS":

                break;
            case "EXIT":
                exit(0);
                break;
        }

    }

    // GAME LOOP IMPLEMENTED
    public void runGame() throws IOException, InterruptedException {
        gameModel = new GameModel();
        PacmanController pacmanController = new PacmanController(gameModel.getMap().getPacman());
        gameView = new CyanView.GameView(gameModel);


        readKeys.setScreen(gameView.getScreen());
        readKeys.addObserver(pacmanController);

        long totalTime = 0;
        long pastTime = System.currentTimeMillis();     // para poder ter o tempo de frame em frame
        while(gameModel.isRunning()){
            long now = System.currentTimeMillis();
            totalTime += now-pastTime;
            while(totalTime >= TIME_FIXED) {
                gameModel.update(TIME_FIXED);
                totalTime-=TIME_FIXED;
            }
            gameView.draw();
            pastTime = now;
        }
        readKeys.removeObserver(pacmanController);
    }

    public void runIntructionMenu() throws IOException, InterruptedException {
        instructionMenuModel = new InstructionMenuModel();
        InstructionMenuController instructionController = new InstructionMenuController(instructionMenuModel);
        viewInstructionMenu = new ViewInstructionMenu(instructionMenuModel);


        readKeys.setScreen(viewInstructionMenu.getScreen());
        readKeys.addObserver(instructionController);

        while(instructionMenuModel.isRunning()){
            viewInstructionMenu.draw();
        }
        readKeys.removeObserver(instructionController);
        viewInstructionMenu.closeScreen();
        run();
    }
}
