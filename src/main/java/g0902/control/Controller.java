package g0902.control;

import g0902.model.Game.GameModel;
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


    public Controller() throws IOException {
        readKeys =  new ReadKeys();
        thread = new Thread(readKeys);
        thread.start();
    }

    public void run() throws IOException {
        if (state == null)
            state = new MainMenuState();

        while(state!=null) {
            viewer = state.getViewer();

            readKeys.setScreen(viewer.getScreen());
            readKeys.addObserver(state.getObserver());

            while (state.isRunning())
                state.step();

            readKeys.removeObserver(state.getObserver());
            viewer.closeScreen();
            setState(state.nextState());
        }
    }

    public void setState(State state) {
        this.state = state;
    }
}

