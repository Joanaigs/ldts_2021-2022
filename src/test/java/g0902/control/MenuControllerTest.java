package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Menu.MainMenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class MenuControllerTest{
    MainMenuModel mainMenuModel;
    MenuController mainMenuController;
    KeyStroke keyStroke;

    @BeforeEach
    public void setUp() throws IOException {
        mainMenuModel = mock(MainMenuModel.class);
        mainMenuController =new MenuController(mainMenuModel);
        keyStroke = mock(KeyStroke.class);
    }
    @Test
    public void ProcessKeyTest() throws IOException, InterruptedException {

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        mainMenuController.processKey(keyStroke);
        verify(mainMenuModel, times(1)).selectNext();

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        mainMenuController.processKey(keyStroke);
        verify(mainMenuModel, times(1)).selectPrevious();

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Enter);
        mainMenuController.processKey(keyStroke);
        verify(mainMenuModel, times(1)).setRunning(false);
    }
}
