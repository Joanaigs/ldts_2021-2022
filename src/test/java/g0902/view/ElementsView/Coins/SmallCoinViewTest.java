package g0902.view.ElementsView.Coins;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import g0902.model.Game.MapElements.Coins.SmallCoin;
import g0902.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class SmallCoinViewTest {
    private TextGraphics tg;
    SmallCoinView view;
    @BeforeEach
    void setUp() {
        Position position=mock(Position.class);
        Screen screen = mock(Screen.class);
        tg = mock(TextGraphics.class);
        view=new SmallCoinView(new SmallCoin(position), tg);
        view.setGraphics(tg);
    }

    @Test
    public void InsDrawTest() {
        view.draw();
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(any());
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition(3, -2), new TerminalSize(2, 1), ' ');
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition(7, -2), new TerminalSize(2, 1), ' ');
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition(7, 1), new TerminalSize(2, 1), ' ');
    }
}
