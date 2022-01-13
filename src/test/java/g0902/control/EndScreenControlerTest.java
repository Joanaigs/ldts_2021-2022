package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import g0902.model.Menu.EndScreenModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class EndScreenControlerTest {
    EndScreenModel model;
    EndScreenControler endScreenControler;
    KeyStroke keyStroke;
    @BeforeEach
    void setUp(){
        model=mock(EndScreenModel.class);
        endScreenControler=new EndScreenControler(model);
        keyStroke= mock(KeyStroke.class);
    }
    @Test
    public void test() throws IOException, InterruptedException {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn('a');
        endScreenControler.processKey(keyStroke);
        endScreenControler.processKey(keyStroke);
        endScreenControler.processKey(keyStroke);
        verify(model, times(3)).addLetter(anyChar());
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Enter);
        endScreenControler.processKey(keyStroke);
        verify(model, times(1)).setRunning(false);
    }
}
