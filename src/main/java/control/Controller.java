package control;

import model.GameModel;
import model.Menu.EndScreenModel;
import model.Menu.InstructionMenuModel;
import model.Menu.MainMenuModel;
import model.Menu.RankingsMenuModel;
import states.*;
import view.ElementsView.GameView;
import view.ViewInstructionMenu;
import view.ViewMainMenu;
import view.Viewer;

import java.io.IOException;

import static java.lang.System.exit;

public class Controller {
    Thread thread;
    ReadKeys readKeys;
    State state;
    Viewer viewer;
    int score;
    String name;


    public Controller() throws IOException {
        readKeys =  new ReadKeys();
        thread = new Thread(readKeys);
        thread.start();
        // chamar construtor do menu controler, o do pacman fica só no run game, e tens de ser tu a chamá-la.
    }

    public void run() throws IOException {
        if(state==null)
            state=new MainMenuState();
        viewer = state.getViewer();

        readKeys.setScreen(viewer.getScreen());
        readKeys.addObserver(state.getObserver());

        while(state.isRunning()){
            state.step();
        }
        readKeys.removeObserver(state.getObserver());
        viewer.closeScreen();

        if(state.getString()=="mainMenu"){
            MainMenuModel mainMenuModel= (MainMenuModel) state.getModel();
            long pastTime = System.currentTimeMillis();
            switch (mainMenuModel.getSelected()) {
                case "START":
                    state=new GameState(pastTime);
                    run();
                    state=new MainMenuState();
                    run();
                    score=((GameModel)state.getModel()).getScore();
                    state=new EndScreenState();
                    ((EndScreenModel)state.getModel()).setScore(score);
                    run();
                    name=((EndScreenModel)state.getModel()).getName();
                    state= new RankingsMenuState();
                    ((RankingsMenuModel)state.getModel()).addScore(name, score);
                    run();
                    state=new MainMenuState();
                    run();
                    break;
                case "INSTRUCTIONS":
                    state=new InstructionMenuState();
                    run();
                    state=new MainMenuState();
                    run();
                    break;
                case "RANKINGS":
                    state= new RankingsMenuState();
                    run();
                    state=new MainMenuState();
                    run();
                    break;
                case "EXIT":
                    exit(0);
                    break;
            }
        }
    }
}
