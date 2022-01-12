package g0902.view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Direction;
import g0902.model.Elements.Ghosts.Types.Cyan;
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
        ghost.setFrightenedModeOn();
        cyanView.draw();
        Mockito.verify(tg, Mockito.times(282)).setBackgroundColor(any());
    }
}
