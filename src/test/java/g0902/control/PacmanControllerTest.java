package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import g0902.model.Direction;
import g0902.model.Game.GameModel;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class PacmanControllerTest {
    Pacman pacman;
    GameModel gameModel;
    PacmanController pacmanController;
    KeyStroke keyStroke;

    @BeforeEach
    public void  setup(){
        pacman =mock(Pacman.class);
        gameModel=mock(GameModel.class);
        pacmanController=new PacmanController(pacman, gameModel);
        keyStroke= mock(KeyStroke.class);
    }

    @Test
    public void processKeyUp() {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        pacmanController.processKey(keyStroke);
        verify(pacman, times(1)).setNextDirection(Direction.Up);
    }

    @Test
    public void processKeyDown() {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        pacmanController.processKey(keyStroke);
        verify(pacman, times(1)).setNextDirection(Direction.Down);
    }

    @Test
    public void processKeyLeft() {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowLeft);
        pacmanController.processKey(keyStroke);
        verify(pacman, times(1)).setNextDirection(Direction.Left);
    }

    @Test
    public void processKeyRight() {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowRight);
        pacmanController.processKey(keyStroke);
        verify(pacman, times(1)).setNextDirection(Direction.Right);
    }

    @Test
    public void processKeyEnter() {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Enter);
        pacmanController.processKey(keyStroke);
        verify(gameModel, times(1)).setRunning(false);
        verify(gameModel, times(1)).setLost(true);
    }

    @Test
    public void getPacman(){
        Assertions.assertEquals(pacman, pacmanController.getPacman());
    }

}
