package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class PacmanControllerTest {
    @Test
    public void test() throws IOException, InterruptedException {
        Pacman model=mock(Pacman.class);
        PacmanController pacmanController=new PacmanController(model);
        KeyStroke keyStroke= mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        pacmanController.processKey(keyStroke);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        pacmanController.processKey(keyStroke);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowLeft);
        pacmanController.processKey(keyStroke);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowRight);
        pacmanController.processKey(keyStroke);
        verify(model, times(4)).setCurrentDirection(any());
    }
}
