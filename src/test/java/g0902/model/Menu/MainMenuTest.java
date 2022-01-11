package g0902.model.Menu;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainMenuTest {
    @Test
    public void selectNext(){
        MainMenuModel main=new MainMenuModel();
        Assertions.assertEquals("START", main.getSelected());
        main.selectNext();
        Assertions.assertEquals(new TextColor.RGB(255, 202, 24), main.getSelectedElement().getFillColor());
        main.selectNext();
        Assertions.assertEquals("LEADERBOARD", main.getSelected());
    }
    @Test
    public void selectPrevious(){
        MainMenuModel main=new MainMenuModel();
        Assertions.assertEquals("START", main.getSelected());
        main.selectNext();
        main.selectNext();
        main.selectPrevious();
        Assertions.assertEquals("INSTRUCTIONS", main.getSelected());
    }

    @Test
    public void setRunning(){
        MainMenuModel main=new MainMenuModel();
        Assertions.assertEquals(true, main.isRunning());
        main.setRunning(false);
        Assertions.assertEquals(false, main.isRunning());

    }
}
