package states;

import control.Observer;
import control.RankingsMenuControler;
import model.Menu.RankingsMenuModel;
import model.Model;
import view.ViewRankingsMenu;
import view.Viewer;

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
    }
}
