package g0902.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import g0902.model.Game.GameModel;
import g0902.view.ElementsView.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.io.IOException;

import static org.mockito.Mockito.*;

public class GameViewTest {
    private Screen screen;
    private TextGraphics tg;
    GameView view;
    GameModel model;
    @BeforeEach
    void setUp() throws IOException {
        screen = mock(Screen.class);
        tg = mock(TextGraphics.class);
        model=new GameModel("map");
        view= new GameView(model, screen, tg);
        view.setGraphics(tg);
    }

    @Test
    public void InsDrawTest() throws IOException {
        view.draw();
        Mockito.verify(screen, times(1)).clear();
        Mockito.verify(tg, times(1181)).setBackgroundColor(any());
        Mockito.verify(tg, Mockito.times(4028)).fillRectangle(any(), any(), anyChar());
        Mockito.verify(screen, times(1)).refresh(Screen.RefreshType.AUTOMATIC);
    }

}
