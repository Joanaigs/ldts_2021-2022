package g0902.states;

import g0902.control.EndScreenControler;
import g0902.control.Observer;
import g0902.control.RankingsMenuControler;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Menu.RankingsMenuModel;
import g0902.model.Model;
import g0902.view.ViewRankingsMenu;
import g0902.view.Viewer;

import java.io.IOException;

public class RankingsMenuState extends State{
    private RankingsMenuModel rankingsMenuModel;
    private RankingsMenuControler rankingsMenuControler;
    private ViewRankingsMenu viewRankingsMenu;

    private void initializing(){
        rankingsMenuModel=new RankingsMenuModel();
        rankingsMenuControler=new RankingsMenuControler(rankingsMenuModel);
    }
    public RankingsMenuState(){
        super();
        initializing();
        viewRankingsMenu=new ViewRankingsMenu(rankingsMenuModel);
    }

    public RankingsMenuState(ViewRankingsMenu view) {
        super();
        initializing();
        viewRankingsMenu=view;
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
    public String getString() {
        return "rankigs";
    }

    @Override
    public void setViewer(Viewer viewer) {
        this.viewRankingsMenu= (ViewRankingsMenu) viewer;
    }

    @Override
    public void step() throws IOException {
        viewRankingsMenu.draw();
    }
}
