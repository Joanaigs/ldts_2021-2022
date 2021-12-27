package model.Menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainMenuTest {
    @Test
    public void selectNext(){
        MainMenuModel main=new MainMenuModel();
        Assertions.assertEquals("START", main.getSelected());
        main.selectNext();
        main.selectNext();
        Assertions.assertEquals("RANKINGS", main.getSelected());
    }
    @Test
    public void selectPrevious(){
        MainMenuModel main=new MainMenuModel();
        Assertions.assertEquals("START", main.getSelected());
        main.selectNext();
        main.selectNext();
        main.selectPrevious();
        Assertions.assertEquals("SETTINGS", main.getSelected());
    }
}
