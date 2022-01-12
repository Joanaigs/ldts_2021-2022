package g0902.view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Direction;
import g0902.model.Game.MapElements.Ghosts.Types.Pink;
import g0902.model.Position;
import g0902.view.ElementsView.Ghosts.PinkView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class PinkViewTest {
    @Test
    void drawTest() throws IOException {
        TextGraphics tg = mock(TextGraphics.class);
        Position position=mock(Position.class);
        Pink ghost= new Pink(position);
        ghost.setCurrentDirection(Direction.Right);
        PinkView pinkView=new PinkView(ghost, tg);
        pinkView.draw();
        Mockito.verify(tg, Mockito.times(141)).setBackgroundColor(any());
        ghost.setFrightenedModeOn();
        pinkView.draw();
        Mockito.verify(tg, Mockito.times(282)).setBackgroundColor(any());
    }
}
