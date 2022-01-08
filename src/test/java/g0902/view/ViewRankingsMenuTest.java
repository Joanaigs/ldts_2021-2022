package g0902.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import g0902.model.Menu.InstructionMenuModel;
import g0902.model.Menu.RankingsMenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

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
        view= new ViewRankingsMenu(model, screen);
        view.setGraphics(tg);
    }

    @Test
    public void InsDrawTest() throws IOException {
        view.draw();
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#ffca18"));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#08ecd9"));
    }
}
