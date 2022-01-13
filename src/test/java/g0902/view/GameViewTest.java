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
import static org.mockito.Mockito.times;

public class GameViewTest {
    private Screen screen;
    private TextGraphics tg;
    GameView view;
    GameModel model;
    @BeforeEach
    void setUp() throws IOException {
        screen = mock(Screen.class);
        tg = mock(TextGraphics.class);
        model=new GameModel();
        view= new GameView(model, screen, tg);
        view.setGraphics(tg);
    }

    @Test
    public void InsDrawTest() throws IOException {
        view.draw();
        Mockito.verify(tg, times(613)).setBackgroundColor(any());
        Mockito.verify(tg, Mockito.times(2968)).fillRectangle(any(), any(), anyChar());
    }

}
