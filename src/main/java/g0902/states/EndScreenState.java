package g0902.states;

import g0902.Configuration;
import g0902.control.EndScreenControler;
import g0902.Music;
import g0902.control.Observer;
import g0902.gui.LanternaGUI;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Menu.RankingsMenuModel;
import g0902.model.Model;
import g0902.view.ViewEndScreen;
import g0902.view.Viewer;

import java.io.IOException;

public class EndScreenState extends State{
    final ViewEndScreen viewEndScreen;
    final EndScreenModel endScreenModel;
    final EndScreenControler endScreenControler;
    LanternaGUI gui;
    Music music;

    public EndScreenState() {
        super();
        endScreenModel= new EndScreenModel();
        endScreenControler=new EndScreenControler(endScreenModel);
        gui=new LanternaGUI();
        gui.createScreenMenu();
        music = Configuration.getInstance().getEndScreenMusic();
        viewEndScreen= new ViewEndScreen(endScreenModel, gui.getScreen());
    }
    //for testing only
    public EndScreenState(ViewEndScreen view, EndScreenModel model, EndScreenControler controller, Music music) {
        super();
        endScreenControler=controller;
        endScreenModel=model;
        this.viewEndScreen=view;
        this.music=music;
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
    public void step() throws IOException {
        Configuration.getInstance().stopGameMusic();
        if(!music.isPlaying()){
            music.start();
        }
        viewEndScreen.draw();
    }

    @Override
    public State nextState() throws IOException {
        String name = endScreenModel.getName();
        State state = new RankingsMenuState();
        ((RankingsMenuModel) state.getModel()).addScore(name, endScreenModel.getScore());
        ((RankingsMenuModel) state.getModel()).updateFile();
        return state;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}
