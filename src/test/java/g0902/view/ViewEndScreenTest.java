package g0902.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import g0902.model.Menu.EndScreenModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ViewEndScreenTest {
    private Screen screen;
    private TextGraphics tg;
    ViewEndScreen view;
    EndScreenModel model;
    @BeforeEach
    void setUp() {
        screen = mock(Screen.class);
        tg = mock(TextGraphics.class);
        model=mock(EndScreenModel.class);
        Mockito.when(model.hasLost()).thenReturn(true);
        view= new ViewEndScreen(model, screen);
        view.setGraphics(tg);
    }

    @Test
    public void InsDrawTest() throws IOException {
        view.draw();
        Mockito.verify(tg, Mockito.times(2)).setForegroundColor(TextColor.Factory.fromString(Constants.YELLOW));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString(Constants.WHITE));
        Mockito.verify(tg, Mockito.times(19)).putString(anyInt(), anyInt(), anyString(),any(), any());
        Mockito.when(model.hasLost()).thenReturn(false);
        //if player loses
        view.draw();
        Mockito.verify(tg, Mockito.times(4)).setForegroundColor(TextColor.Factory.fromString(Constants.YELLOW));
        Mockito.verify(tg, Mockito.times(2)).setForegroundColor(TextColor.Factory.fromString(Constants.WHITE));
        Mockito.verify(tg, Mockito.times(39)).putString(anyInt(), anyInt(), anyString(),any(), any());
        Mockito.verify(screen, Mockito.times(2)).refresh();

    }
}
