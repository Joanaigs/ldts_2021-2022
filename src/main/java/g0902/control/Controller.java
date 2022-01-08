package g0902.control;

import g0902.model.GameModel;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Menu.MainMenuModel;
import g0902.model.Menu.RankingsMenuModel;
import g0902.states.*;
import g0902.view.Viewer;

import java.io.IOException;

import static java.lang.System.exit;

public class Controller {
    Thread thread;
    ReadKeys readKeys;
    State state;
    Viewer viewer;
    int score;
    String name;
    boolean lost;

    MenuController menuController;
    public static final long TIME_FIXED = 20;


    public Controller() throws IOException {
        readKeys =  new ReadKeys();
        thread = new Thread(readKeys);
        thread.start();
        // chamar construtor do menu controler, o do pacman fica só no run game, e tens de ser tu a chamá-la.
    }

    public void run() throws IOException {
        if (state == null)
            state = new MainMenuState();
        viewer = state.getViewer();

        readKeys.setScreen(viewer.getScreen());
        readKeys.addObserver(state.getObserver());

        while (state.isRunning()) {
            state.step();
        }
        readKeys.removeObserver(state.getObserver());
        viewer.closeScreen();
        options();
    }

    public void options() throws IOException {
        if (state.getString() == "mainMenu") {
            MainMenuModel mainMenuModel = (MainMenuModel) state.getModel();
            long pastTime = System.currentTimeMillis();
            switch (mainMenuModel.getSelected()) {
                case "START":
                    state = new GameState();
                    run();
                    lost=((GameModel) state.getModel()).hasLost();
                    score = ((GameModel) state.getModel()).getScore();
                    state = new EndScreenState();
                    ((EndScreenModel) state.getModel()).setScore(score);
                    ((EndScreenModel) state.getModel()).setLost(lost);
                    run();
                    name = ((EndScreenModel) state.getModel()).getName();
                    state = new RankingsMenuState();
                    ((RankingsMenuModel) state.getModel()).addScore(name, score);
                    ((RankingsMenuModel) state.getModel()).updateFile();
                    run();
                    state = new MainMenuState();
                    run();
                    break;
                case "INSTRUCTIONS":
                    state = new InstructionMenuState();
                    run();
                    state = new MainMenuState();
                    run();
                    break;
                case "RANKINGS":
                    state = new RankingsMenuState();
                    run();
                    state = new MainMenuState();
                    run();
                    break;
                case "EXIT":
                    exit(0);
                    break;
            }
        }
    }

    public void setState(State state) {
        this.state = state;
    }
}

