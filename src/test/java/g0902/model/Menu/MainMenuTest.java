package g0902.model.Menu;

import com.googlecode.lanterna.TextColor;
import g0902.model.Menu.Options.MenuElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class MainMenuTest {
    private MainMenuModel main;
    private MainMenuModel mainMock;
    private MenuElement menuElement;

    @BeforeEach
    public void setup(){
        main=new MainMenuModel();
        mainMock = mock(MainMenuModel.class);
        menuElement = mock(MenuElement.class);
    }

    @Test
    public void selectNext(){
        Assertions.assertEquals("START", main.getSelected());
        main.selectNext();
        Assertions.assertEquals(new TextColor.RGB(255, 202, 24), main.getSelectedElement().getFillColor());
        main.selectNext();
        Assertions.assertEquals("LEADERBOARD", main.getSelected());
        main.selectNext();
        main.selectNext();
        Assertions.assertEquals("EXIT", main.getSelected());;
    }
    @Test
    public void selectPrevious(){
        Assertions.assertEquals("START", main.getSelected());
        main.selectPrevious();
        Assertions.assertEquals("START", main.getSelected());
        main.selectNext();
        main.selectNext();
        main.selectPrevious();
        Assertions.assertEquals("INSTRUCTIONS", main.getSelected());
    }

    @Test
    public void setRunning(){
        Assertions.assertEquals(true, main.isRunning());
        main.setRunning(false);
        Assertions.assertEquals(false, main.isRunning());

    }
}
