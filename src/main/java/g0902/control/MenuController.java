package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import g0902.model.Menu.MainMenuModel;


import static java.lang.System.exit;

public class MenuController implements Observer{
    final MainMenuModel mainMenuModel;

    public MenuController(MainMenuModel mainMenuModel) {
        this.mainMenuModel=mainMenuModel;
    }

    @Override
    @SuppressWarnings("MissingCasesInEnumSwitch")
    public void processKey(KeyStroke key) {
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
