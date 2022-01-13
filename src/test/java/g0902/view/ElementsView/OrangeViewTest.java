package g0902.view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Direction;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Orange;
import g0902.model.Position;
import g0902.view.ElementsView.Ghosts.OrangeView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class OrangeViewTest {
    @Test
    void drawTest() throws IOException {
        TextGraphics tg = mock(TextGraphics.class);
        Position position=mock(Position.class);
        Orange ghost= new Orange(position);
        ghost.setCurrentDirection(Direction.Right);
        OrangeView orangeView=new OrangeView(ghost, tg);
        orangeView.draw();
        Mockito.verify(tg, Mockito.times(141)).setBackgroundColor(any());
        ghost.setFrightenedModeOn();
        orangeView.draw();
        Mockito.verify(tg, Mockito.times(282)).setBackgroundColor(any());
    }
}
