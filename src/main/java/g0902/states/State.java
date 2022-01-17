package g0902.states;

import g0902.control.Observer;
import g0902.model.Model;
import g0902.view.Viewer;

import java.io.IOException;

public abstract class State{

    public abstract Viewer getViewer();

    public abstract Observer getObserver();

    public abstract Model getModel();

    public abstract boolean isRunning();

    public abstract void step() throws IOException;

    public abstract State nextState() throws IOException;
}
