package g0902.view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Direction;
import g0902.model.Game.MapElements.Ghosts.Types.Red;
import g0902.model.Position;
import g0902.view.ElementsView.Ghosts.RedView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class RedViewTest {
    @Test
    void drawTest() throws IOException {
        TextGraphics tg = mock(TextGraphics.class);
        Position position=mock(Position.class);
        Red ghost= new Red(position);
        ghost.setCurrentDirection(Direction.Right);
        RedView redView=new RedView(ghost, tg);
        redView.draw();
        Mockito.verify(tg, Mockito.times(141)).setBackgroundColor(any());
        ghost.setFrightenedModeOn();
        redView.draw();
        Mockito.verify(tg, Mockito.times(282)).setBackgroundColor(any());
    }
}
