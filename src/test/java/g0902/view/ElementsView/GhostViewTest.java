package g0902.view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.view.Draws;
import g0902.model.Direction;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Cyan;
import g0902.view.ElementsView.Ghosts.CyanView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class GhostViewTest {
    @Test
    void setGhostDrawTest(){
        TextGraphics tg = mock(TextGraphics.class);
        Cyan ghost= mock(Cyan.class);
        CyanView cyanView=new CyanView(ghost, tg);
        cyanView.setGhostDraw(Direction.Right);
        Assertions.assertEquals(Draws.RIGHT_GHOST, cyanView.setGhostDraw(Direction.Right));
        Assertions.assertEquals(Draws.LEFT_GHOST, cyanView.setGhostDraw(Direction.Left));
        Assertions.assertEquals(Draws.UP_GHOST, cyanView.setGhostDraw(Direction.Up));
        Assertions.assertEquals(Draws.DOWN_GHOST, cyanView.setGhostDraw(Direction.Down));
    }

}
