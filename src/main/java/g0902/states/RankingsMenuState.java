package g0902.states;

import g0902.Configuration;
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
    private final ViewRankingsMenu viewRankingsMenu;
    LanternaGUI gui;

    public RankingsMenuState() throws FileNotFoundException {
        super();
        rankingsMenuModel=new RankingsMenuModel();
        rankingsMenuControler=new RankingsMenuControler(rankingsMenuModel);
        gui=new LanternaGUI();
        gui.createScreenMenu();
        viewRankingsMenu=new ViewRankingsMenu(rankingsMenuModel, gui.getScreen());
    }
    //for test purpose only
    public RankingsMenuState(ViewRankingsMenu view, RankingsMenuModel rankingsMenuModel, RankingsMenuControler rankingsMenuControler) {
        super();
        viewRankingsMenu=view;
        this.rankingsMenuControler=rankingsMenuControler;
        this.rankingsMenuModel=rankingsMenuModel;
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
        if(Configuration.getInstance().getEndScreenMusic().isPlaying())
            Configuration.getInstance().getEndScreenMusic().stop();
        return new MainMenuState();
    }
}