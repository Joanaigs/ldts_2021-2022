package g0902.states;

import g0902.Configuration;
import g0902.Music;
import g0902.control.Observer;
import g0902.control.RankingsMenuControler;
import g0902.gui.LanternaGUI;
import g0902.model.Menu.RankingsMenuModel;
import g0902.model.Model;
import g0902.view.ViewRankingsMenu;
import g0902.view.Viewer;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RankingsMenuState extends State{
    private final RankingsMenuModel rankingsMenuModel;
    private final RankingsMenuControler rankingsMenuControler;
    private ViewRankingsMenu viewRankingsMenu;
    LanternaGUI gui;
    Music music;

    public RankingsMenuState() throws FileNotFoundException {
        super();
        rankingsMenuModel=new RankingsMenuModel();
        rankingsMenuControler=new RankingsMenuControler(rankingsMenuModel);
        gui=new LanternaGUI();
        music = Configuration.getInstance().getEndScreenMusic();
    }

    //for test purpose only
    public RankingsMenuState(ViewRankingsMenu view, RankingsMenuModel rankingsMenuModel, RankingsMenuControler rankingsMenuControler, Music music, LanternaGUI gui) {
        super();
        viewRankingsMenu=view;
        this.rankingsMenuControler=rankingsMenuControler;
        this.rankingsMenuModel=rankingsMenuModel;
        this.gui=gui;
        this.music=music;
    }

    @Override
    public void initScreen(){
        gui.createScreenMenu();
        viewRankingsMenu=new ViewRankingsMenu(rankingsMenuModel, gui.getScreen());
    }

    @Override
    public Viewer getViewer(){
        return viewRankingsMenu;
    }

    @Override
    public Observer getObserver(){
        return rankingsMenuControler;
    }

    @Override
    public Model getModel() {
        return rankingsMenuModel;
    }

    @Override
    public boolean isRunning() {
        return rankingsMenuModel.isRunning();
    }


    @Override
    public void step() throws IOException {
        viewRankingsMenu.draw();
    }

    @Override
    public State nextState() {
        if(music.isPlaying())
            music.stop();
        return new MainMenuState();
    }
}