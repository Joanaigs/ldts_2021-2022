package g0902.states;

import g0902.control.Observer;
import g0902.control.RankingsMenuControler;
import g0902.model.Menu.RankingsMenuModel;
import g0902.model.Model;
import g0902.view.ViewRankingsMenu;
import g0902.view.Viewer;

import java.io.IOException;

public class RankingsMenuState extends State{
    private RankingsMenuModel rankingsMenuModel;
    private RankingsMenuControler rankingsMenuControler;
    private ViewRankingsMenu viewRankingsMenu;
    public RankingsMenuState() throws IOException {
        super();
        rankingsMenuModel=new RankingsMenuModel();
        rankingsMenuControler=new RankingsMenuControler(rankingsMenuModel);
        viewRankingsMenu=new ViewRankingsMenu(rankingsMenuModel);
    }

    @Override
    public Viewer getViewer() throws IOException {
        return viewRankingsMenu;
    }

    @Override
    public Observer getObserver() throws IOException {
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
    public void step() throws IOException {
        viewRankingsMenu.draw();
    }
}
