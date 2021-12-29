package control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import model.Menu.MainMenuModel;

import java.io.IOException;

public class MenuController extends Controller implements Observer{
    MainMenuModel mainMenuModel;
    MenuController(MainMenuModel mainMenuModel) throws IOException {
        super();
        this.mainMenuModel=mainMenuModel;
    }

    @Override
    public void processKey(KeyStroke key) throws IOException, InterruptedException {
        if(key.getKeyType() == KeyType.ArrowUp){
            mainMenuModel.selectPrevious();
        }
        else if(key.getKeyType() == KeyType.ArrowDown){
            mainMenuModel.selectNext();
        }
        else if(key.getKeyType()== KeyType.Enter){
            mainMenuModel.setRunning(false);

        }
    }

}
