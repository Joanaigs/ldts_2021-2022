package g0902.view.ElementsView.Coins;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import g0902.model.Game.MapElements.Coins.PowerCoin;
import g0902.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class PowerCoinViewTest {
    private TextGraphics tg;
    PowerCoinView view;
    @BeforeEach
    void setUp() {
        Position position=mock(Position.class);
        Mockito.when(position.getCol()).thenReturn(1);
        Mockito.when(position.getRow()).thenReturn(2);
        tg = mock(TextGraphics.class);
        view=new PowerCoinView(new PowerCoin(position), tg);
        view.setGraphics(tg);
    }

    @Test
    public void InsDrawTest() {
        view.draw();
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(any());
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition( 4, 2),  new TerminalSize(2, 1), ' ');
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition( 10, 2),  new TerminalSize(2, 1), ' ');
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition( 0, 5),  new TerminalSize(2, 1), ' ');
    }
}
