package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import model.Menu.RankingsMenuModel;
import model.Model;
import model.Pair;

import java.io.IOException;
import java.util.List;

public class ViewRankingsMenu extends ViewerMenu {
    RankingsMenuModel rankingsMenuModel;
    public ViewRankingsMenu(RankingsMenuModel rankingsMenuModel) {
        super(rankingsMenuModel);
        this.rankingsMenuModel=rankingsMenuModel;
    }


    @Override
    public void draw() throws IOException {
        
    }
}
