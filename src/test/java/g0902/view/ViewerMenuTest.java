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

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class ViewerMenuTest {
    private Screen screen;
    private TextGraphics tg;
    MainMenuModel model;
    ViewerMenu view;
    @BeforeEach
    void setUp() throws IOException {
        screen = mock(Screen.class);
        tg = mock(TextGraphics.class);
        model=mock(MainMenuModel.class);
        view= mock(ViewerMenu.class);
        view.setGraphics(tg);
        view.initScreen();
    }

    @Test
    public void InsDrawTest() throws IOException {
        view.draw();
        Mockito.verify(view, Mockito.times(1)).initScreen();
    }
}
