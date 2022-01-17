package g0902.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import g0902.Constants;
import g0902.model.Menu.RankingsMenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ViewRankingsMenuTest {
    private Screen screen;
    private TextGraphics tg;
    ViewRankingsMenu view;
    RankingsMenuModel model;
    @BeforeEach
    void setUp() throws IOException {
        screen = mock(Screen.class);
        tg = mock(TextGraphics.class);
        model=new RankingsMenuModel();
        model.readFile("RankingTest2");
        view= new ViewRankingsMenu(model, screen);
        view.setGraphics(tg);
    }

    @Test
    public void InsDrawTest() throws IOException {
        view.draw();
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString(Constants.YELLOW));
        Mockito.verify(tg, Mockito.times(2)).setForegroundColor(TextColor.Factory.fromString(Constants.WHITE));
        Mockito.verify(tg, Mockito.times(1)).putString(6, 2, " __              _         _                 _ ", SGR.BOLD);
        Mockito.verify(tg, Mockito.times(1)).putString(8, 14, "1", SGR.BOLD);
        Mockito.verify(tg, Mockito.times(1)).putString(8, 15, "2", SGR.BOLD);
        Mockito.verify(tg, Mockito.times(0)).putString(8, 15, "3", SGR.BOLD);
        Mockito.verify(tg, Mockito.times(1)).putString(22, 14, "JIG", SGR.BOLD);
        Mockito.verify(tg, Mockito.times(1)).putString(37, 15, "2000", SGR.BOLD);
        Mockito.verify(tg, Mockito.times(1)).putString(37, 14, "1000", SGR.BOLD);
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }
}
