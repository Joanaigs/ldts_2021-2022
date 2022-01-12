package g0902.view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Elements.Ghosts.Types.Cyan;
import g0902.model.Position;
import g0902.view.ElementsView.Ghosts.FrightenedView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class FrightenedViewTest {
    @Test
    void drawTest() throws IOException {
        TextGraphics tg = mock(TextGraphics.class);
        Position position=mock(Position.class);
        Cyan ghost= new Cyan(position);
        FrightenedView frightenedView=new FrightenedView(ghost, tg);
        frightenedView.draw();
        Mockito.verify(tg, Mockito.times(141)).setBackgroundColor(any());
    }
}
