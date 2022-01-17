package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import g0902.model.Menu.MainMenuModel;

import java.io.IOException;

import static java.lang.System.exit;

public class MenuController implements Observer{
    MainMenuModel mainMenuModel;

    public MenuController(MainMenuModel mainMenuModel) {
        this.mainMenuModel=mainMenuModel;
    }

    @Override
    public void processKey(KeyStroke key) throws IOException, InterruptedException {
        switch(key.getKeyType()){
            case ArrowUp -> mainMenuModel.selectPrevious();
            case ArrowDown -> mainMenuModel.selectNext();
            case Enter -> mainMenuModel.setRunning(false);
            case Character -> {
                if(key.getCharacter()=='x' ||  key.getCharacter()=='X')
                                    exit(0);
            }
        }
    }

}
