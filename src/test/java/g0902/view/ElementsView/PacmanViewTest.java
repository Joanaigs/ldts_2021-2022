package g0902.view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.Constants;
import g0902.model.Direction;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import g0902.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class PacmanViewTest{
    @Test
    void drawTest(){
        TextGraphics tg = mock(TextGraphics.class);
        Pacman pacman = new Pacman(new Position(8, 12));
        PacmanView pacmanView=new PacmanView(pacman, tg);
        String[] st= new String[0];
        Assertions.assertEquals(Constants.PAC_OPEN_DOWN, pacmanView.setPacDraw(st));
        pacman.setCurrentDirection(Direction.Up);
        PacmanView pacmanView1=new PacmanView(pacman, tg);
        Assertions.assertEquals(Constants.PAC_OPEN_UP, pacmanView1.setPacDraw(st));
        pacman.setCurrentDirection(Direction.Left);
        PacmanView pacmanView2=new PacmanView(pacman, tg);
        Assertions.assertEquals(Constants.PAC_OPEN_LEFT, pacmanView2.setPacDraw(st));
        pacman.setCurrentDirection(Direction.Right);
        PacmanView pacmanView3=new PacmanView(pacman, tg);
        Assertions.assertEquals(Constants.PAC_OPEN_RIGHT, pacmanView3.setPacDraw(st));
        pacman.setCurrentDirection(Direction.None);
        PacmanView pacmanView4=new PacmanView(pacman, tg);
        Assertions.assertEquals(Constants.PAC_CLOSE, pacmanView4.setPacDraw(st));

    }
}
