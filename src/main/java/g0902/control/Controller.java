package g0902.control;

import g0902.states.*;
import g0902.view.Viewer;

import java.io.IOException;


public class Controller {
    final Thread thread;
    ReadKeys readKeys;
    State state;
    Viewer viewer;


    public Controller(){
        readKeys =  new ReadKeys();
        thread = new Thread(readKeys);
        thread.start();
    }

    public void run() throws IOException {
        if (state == null) {
            state = new MainMenuState();
            state.initScreen();
        }

        while(state!=null) {
            viewer = state.getViewer();

            readKeys.setScreen(viewer.getScreen());
            readKeys.addObserver(state.getObserver());

            while (state.isRunning())
                state.step();

            readKeys.removeObserver(state.getObserver());
            viewer.closeScreen();
            setState(state.nextState());
            if(state != null)
                state.initScreen();
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setReadKeys(ReadKeys readKeys) {
        this.readKeys = readKeys;
    }

    public Thread getThread() {return thread;}
    public ReadKeys getReadKeys() {return readKeys;}
}