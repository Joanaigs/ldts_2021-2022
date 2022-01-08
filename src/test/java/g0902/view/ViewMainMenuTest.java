package g0902.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Menu.MainMenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ViewMainMenuTest {
    private Screen screen;
    private TextGraphics tg;
    ViewMainMenu view;
    MainMenuModel model;
    @BeforeEach
    void setUp() throws IOException {
        screen = mock(Screen.class);
        tg = mock(TextGraphics.class);
        model=mock(MainMenuModel.class);
        view= new ViewMainMenu(model, screen);
        view.setGraphics(tg);
    }

    @Test
    public void InsDrawTest() throws IOException {
        view.draw();
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#ffca18"));
        Mockito.verify(tg, Mockito.times(6)).putString(anyInt(), anyInt(), anyString());

    }
}
