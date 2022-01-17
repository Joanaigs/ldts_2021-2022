package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import g0902.model.Menu.RankingsMenuModel;

import static java.lang.System.exit;

public class RankingsMenuControler implements Observer {
    final RankingsMenuModel rankingsMenuModel;
    public RankingsMenuControler(RankingsMenuModel rankingsMenuModel) {
        this.rankingsMenuModel=rankingsMenuModel;}

    @Override
    public void processKey(KeyStroke key) {
        if(key.getKeyType() == KeyType.Escape){
            rankingsMenuModel.setRunning(false);
        }
        if(key.getKeyType() == KeyType.Character){
            if(key.getCharacter()=='x' ||  key.getCharacter()=='X')
                exit(0);
        }
    }
}
