package g0902.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import g0902.model.Menu.RankingsMenuModel;
import g0902.model.Pair;

import java.io.IOException;
import java.util.List;

public class ViewRankingsMenu extends ViewerMenu {
    RankingsMenuModel rankingsMenuModel;
    public ViewRankingsMenu(RankingsMenuModel rankingsMenuModel) {
        super(rankingsMenuModel);
        this.rankingsMenuModel=rankingsMenuModel;
    }

    public void titleDraw(){
        String s1 = " __              _         _                 _ ";
        String s2 = "|  |   ___ ___ _| |___ ___| |_ ___ ___ ___ _| |";
        String s3 = "|  |__| -_| .'| . | -_|  _| . | . | .'|  _| . |";
        String s4 = "|_____|___|__,|___|___|_| |___|___|__,|_| |___|";

        graphics.setForegroundColor(TextColor.Factory.fromString("#ffca18"));//yellow
        graphics.putString(6, 2, s1, SGR.BOLD);
        graphics.putString(6, 3, s2, SGR.BOLD);
        graphics.putString(6, 4, s3, SGR.BOLD);
        graphics.putString(6, 5, s4, SGR.BOLD);
    }

    public void rankDraw(){
        String s5 = " _  _             _     __    __ __ _  _  __";
        String s6 = "|_)|_||\\||/   |\\||_||V||_    (_ /  / \\|_)|_ ";
        String s7 = "| \\| || ||\\   | || || ||__   __)\\__\\_/| \\|__";
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        graphics.putString(8, 10, s5, SGR.BOLD);
        graphics.putString(8, 11, s6, SGR.BOLD);
        graphics.putString(8, 12, s7, SGR.BOLD);
        List<Pair<String, Integer>> scores=rankingsMenuModel.getScores();
        int row=14;
        for(int i=0; i<scores.size() && i<10; i++){
            Pair<String, Integer> temp=scores.get(i);
            graphics.putString(8, row, String.valueOf((i+1)), SGR.BOLD);
            graphics.putString(22, row, temp.getL(), SGR.BOLD);
            graphics.putString(37, row, String.valueOf(temp.getR()), SGR.BOLD);
            row++;
        }
    }

    @Override
    public void draw() throws IOException {
        graphics.setForegroundColor(TextColor.Factory.fromString("#08ecd9"));
        titleDraw();
        graphics.putString(1, 1, "<-MAIN MENU", SGR.BLINK);
        rankDraw();
        screen.refresh();

    }
}
