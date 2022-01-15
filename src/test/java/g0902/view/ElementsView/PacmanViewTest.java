package g0902.view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.Constants;
import g0902.model.Direction;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import g0902.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class PacmanViewTest{
    TextGraphics tg;
    Pacman pacman;
    PacmanView pacmanView;

    @BeforeEach
    void setUp(){
        tg = mock(TextGraphics.class);
        pacman = new Pacman(new Position(8, 12));
        pacmanView=new PacmanView(pacman, tg);
    }

    @Test
    void setPacDraw(){
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

        pacman.setMouthOpen(false);
        PacmanView pacmanView5=new PacmanView(pacman, tg);
        Assertions.assertEquals(Constants.PAC_CLOSE, pacmanView5.setPacDraw(st));

    }
    @Test
    void drawTest(){
        pacmanView.draw();
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#EECD40"));
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition(24, 10), new TerminalSize(2, 1), ' ');
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition(30, 10), new TerminalSize(2, 1), ' ');
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition(16, 16), new TerminalSize(2, 1), ' ');

    }
}
