package g0902.view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Constants;
import g0902.model.Elements.Direction;
import g0902.model.Elements.Ghosts.Types.Cyan;
import g0902.model.Elements.Pacman;
import g0902.model.Position;
import g0902.view.ElementsView.Ghosts.CyanView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class PacmanViewTest{
    @Test
    void drawTest(){
        TextGraphics tg = mock(TextGraphics.class);
        Pacman pacman = new Pacman(new Position(8, 12));
        PacmanView pacmanView=new PacmanView(pacman, tg);
        String[] st= new String[0];
        Assertions.assertEquals(Constants.PAC_OPEN_DOWN, pacmanView.setPacDraw(st));
        pacman.setDirection(Direction.Up);
        pacman.nextDirection();
        PacmanView pacmanView1=new PacmanView(pacman, tg);
        Assertions.assertEquals(Constants.PAC_OPEN_UP, pacmanView1.setPacDraw(st));
        pacman.setDirection(Direction.Left);
        pacman.nextDirection();
        PacmanView pacmanView2=new PacmanView(pacman, tg);
        Assertions.assertEquals(Constants.PAC_OPEN_LEFT, pacmanView2.setPacDraw(st));
        pacman.setDirection(Direction.Right);
        pacman.nextDirection();
        PacmanView pacmanView3=new PacmanView(pacman, tg);
        Assertions.assertEquals(Constants.PAC_OPEN_RIGHT, pacmanView3.setPacDraw(st));
        pacman.setDirection(Direction.None);
        pacman.nextDirection();
        PacmanView pacmanView4=new PacmanView(pacman, tg);
        Assertions.assertEquals(Constants.PAC_CLOSE, pacmanView4.setPacDraw(st));

    }
}