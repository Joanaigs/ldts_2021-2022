package g0902.view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Constants;
import g0902.model.Elements.Direction;
import g0902.model.Elements.Ghosts.Ghost;
import g0902.model.Elements.Ghosts.Types.Cyan;
import g0902.view.ElementsView.Ghosts.CyanView;
import g0902.view.ElementsView.Ghosts.GhostView;
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
        Assertions.assertEquals(Constants.RIGHT_GHOST, cyanView.setGhostDraw(Direction.Right));
        Assertions.assertEquals(Constants.LEFT_GHOST, cyanView.setGhostDraw(Direction.Left));
        Assertions.assertEquals(Constants.UP_GHOST, cyanView.setGhostDraw(Direction.Up));
        Assertions.assertEquals(Constants.DOWN_GHOST, cyanView.setGhostDraw(Direction.Down));
    }

}
