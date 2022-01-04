package g0902.states;

import g0902.control.EndScreenControler;
import g0902.control.Observer;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Model;
import g0902.view.ViewEndScreen;
import g0902.view.Viewer;

import java.io.IOException;

public class EndScreenState extends State{
    ViewEndScreen viewEndScreen;
    EndScreenModel endScreenModel;
    EndScreenControler endScreenControler;
    public EndScreenState() throws IOException {
        super();
        endScreenModel= new EndScreenModel();
        viewEndScreen= new ViewEndScreen(endScreenModel);
        endScreenControler=new EndScreenControler(endScreenModel);
    }

    @Override
    public Viewer getViewer() throws IOException {
        return viewEndScreen;
    }

    @Override
    public Observer getObserver() throws IOException {
        return endScreenControler;
    }

    @Override
    public Model getModel() {
        return endScreenModel;
    }

    @Override
    public boolean isRunning() {
        return endScreenModel.isRunning();
    }

    @Override
    public String getString() {
        return "EndScreen";
    }

    @Override
    public void step() throws IOException {
        viewEndScreen.draw();
    }
}
