package control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import model.Menu.InstructionMenuModel;
import model.Menu.RankingsMenuModel;


public class RankingsMenuControler implements Observer {
    RankingsMenuModel rankingsMenuModel;
    public RankingsMenuControler(RankingsMenuModel rankingsMenuModel) {
        this.rankingsMenuModel=rankingsMenuModel;}

    @Override
    public void processKey(KeyStroke key) {
        if(key.getKeyType() == KeyType.Enter){
            rankingsMenuModel.setRunning(false);
        }
    }
}
