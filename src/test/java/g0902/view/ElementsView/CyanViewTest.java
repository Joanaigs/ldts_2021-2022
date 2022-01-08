package g0902.view.ElementsView;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Constants;
import g0902.model.Elements.Direction;
import g0902.model.Elements.Ghosts.Types.Cyan;
import g0902.model.Position;
import g0902.view.ElementsView.Ghosts.CyanView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.xml.stream.events.ProcessingInstruction;
import java.io.IOException;
import java.security.PolicySpi;

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
