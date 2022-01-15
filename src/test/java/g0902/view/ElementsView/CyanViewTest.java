package g0902.view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Direction;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Cyan;
import g0902.model.Position;
import g0902.view.ElementsView.Ghosts.CyanView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class CyanViewTest {
    @Test
    void drawTest() throws IOException {
        TextGraphics tg = mock(TextGraphics.class);
        Position position=mock(Position.class);
        Cyan ghost= new Cyan(position);
        ghost.setCurrentDirection(Direction.Right);
        CyanView cyanView=new CyanView(ghost, tg);
        cyanView.draw();
        Mockito.verify(tg, Mockito.times(141)).setBackgroundColor(any());
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition( 1, 2),  new TerminalSize(2, 1), ' ');
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition( 7, 2),  new TerminalSize(2, 1), ' ');
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition( 9, 5),  new TerminalSize(2, 1), ' ');
        ghost.setFrightenedModeOn();
        CyanView cyanView1=new CyanView(ghost, tg);
        cyanView1.draw();
        Mockito.verify(tg, Mockito.times(2)).fillRectangle(new TerminalPosition( 1, 2),  new TerminalSize(2, 1), ' ');
        Mockito.verify(tg, Mockito.times(2)).fillRectangle(new TerminalPosition( 7, 2),  new TerminalSize(2, 1), ' ');
        Mockito.verify(tg, Mockito.times(2)).fillRectangle(new TerminalPosition( 9, 5),  new TerminalSize(2, 1), ' ');
        Mockito.verify(tg, Mockito.times(282)).setBackgroundColor(any());
    }
}
