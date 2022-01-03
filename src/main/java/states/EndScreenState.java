package states;

import control.EndScreenControler;
import control.Observer;
import model.Menu.EndScreenModel;
import model.Model;
import view.ViewEndScreen;
import view.Viewer;

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
