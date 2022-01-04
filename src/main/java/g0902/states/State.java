package g0902.states;

import g0902.control.Observer;
import g0902.model.Model;
import g0902.view.Viewer;

import java.io.IOException;

public abstract class State{
    private final Viewer viewer;

    public State() throws IOException {
        this.viewer = getViewer();
    }

    public abstract Viewer getViewer() throws IOException;

    public abstract Observer getObserver() throws IOException;

    public abstract Model getModel();

    public abstract boolean isRunning();

    public abstract String getString();


    public abstract void step() throws IOException;
}
