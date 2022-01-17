package g0902.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import g0902.model.Menu.MainMenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ViewMainMenuTest {
    private Screen screen;
    private TextGraphics tg;
    ViewMainMenu view;
    MainMenuModel model;
    @BeforeEach
    void setUp() {
        screen = mock(Screen.class);
        tg = mock(TextGraphics.class);
        model=new MainMenuModel();
        view= new ViewMainMenu(model, screen);
        view.setGraphics(tg);
    }

    @Test
    public void InsDrawTest() throws IOException {
        view.draw();
        Mockito.verify(tg, Mockito.times(2)).setForegroundColor(TextColor.Factory.fromString("#ffca18"));
        Mockito.verify(tg, Mockito.times(4)).putString(anyInt(), anyInt(), anyString());
        Mockito.verify(tg, Mockito.times(1)).putString(27, 12,"START" , SGR.BOLD);
        Mockito.verify(tg, Mockito.times(1)).putString(27, 13,"-----" , SGR.BLINK);
        Mockito.verify(tg, Mockito.times(1)).putString(23, 15,"INSTRUCTIONS" , SGR.BOLD);
        Mockito.verify(tg, Mockito.times(1)).putString(23, 16,"------------" , SGR.BLINK);
        Mockito.verify(screen, Mockito.times(1)).refresh();

    }
}
