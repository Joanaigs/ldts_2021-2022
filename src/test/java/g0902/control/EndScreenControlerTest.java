package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import g0902.model.Menu.EndScreenModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class EndScreenControlerTest {
    @Test
    public void test() throws IOException, InterruptedException {
        EndScreenModel model=mock(EndScreenModel.class);
        EndScreenControler endScreenControler=new EndScreenControler(model);
        KeyStroke keyStroke= mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Enter);
        endScreenControler.processKey(keyStroke);
        verify(model, times(1)).setRunning(false);
    }
}
