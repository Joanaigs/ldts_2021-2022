package model.Menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainMenuTest {
    @Test
    public void selectNext(){
        MainMenu main=new MainMenu();
        Assertions.assertEquals("START", main.getSelected());
        main.selectNext();
        main.selectNext();
        Assertions.assertEquals("RANKINGS", main.getSelected());
    }
    @Test
    public void selectPrevious(){
        MainMenu main=new MainMenu();
        Assertions.assertEquals("START", main.getSelected());
        main.selectNext();
        main.selectNext();
        main.selectPrevious();
        Assertions.assertEquals("SETTINGS", main.getSelected());
    }
}
