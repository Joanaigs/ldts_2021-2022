package control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import model.Menu.MainMenuModel;
import states.GameState;
import states.InstructionMenuState;
import states.MainMenuState;
import states.State;
import view.Viewer;

import java.io.IOException;

import static java.lang.System.exit;

public class MenuController implements Observer{
    MainMenuModel mainMenuModel;

    public MenuController(MainMenuModel mainMenuModel) throws IOException {
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
