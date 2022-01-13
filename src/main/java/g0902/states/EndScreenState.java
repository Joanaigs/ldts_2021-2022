package g0902.states;

import g0902.control.EndScreenControler;
import g0902.control.Observer;
import g0902.gui.LanternaGUI;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Menu.RankingsMenuModel;
import g0902.model.Model;
import g0902.view.ViewEndScreen;
import g0902.view.Viewer;

import java.io.IOException;

public class EndScreenState extends State{
    ViewEndScreen viewEndScreen;
    EndScreenModel endScreenModel;
    EndScreenControler endScreenControler;
    LanternaGUI gui;

    private void initializing(){
        endScreenModel= new EndScreenModel();
        endScreenControler=new EndScreenControler(endScreenModel);
        gui=new LanternaGUI();
        gui.createScreenMenu();
    }
    public EndScreenState() {
        super();
        initializing();
        viewEndScreen= new ViewEndScreen(endScreenModel, gui.getScreen());
    }
    //for testing only
    public EndScreenState(ViewEndScreen view) {
        super();
        initializing();
        this.viewEndScreen=view;
    }

    @Override
    public Viewer getViewer() {return viewEndScreen;}

    @Override
    public Observer getObserver()  {return endScreenControler;}

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
    public void setViewer(Viewer viewer) {
        this.viewEndScreen= (ViewEndScreen) viewer;
    }

    @Override
    public void step() throws IOException {viewEndScreen.draw();}

    @Override
    public State nextState() throws IOException {
        String name = endScreenModel.getName();
        State state = new RankingsMenuState();
        ((RankingsMenuModel) state.getModel()).addScore(name, endScreenModel.getScore());
        ((RankingsMenuModel) state.getModel()).updateFile();
        return state;
    }
}
