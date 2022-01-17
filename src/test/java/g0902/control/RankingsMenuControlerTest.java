package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import g0902.model.Menu.RankingsMenuModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class RankingsMenuControlerTest {
    @Test
    public void test() throws IOException, InterruptedException {
        RankingsMenuModel model=mock(RankingsMenuModel.class);
        RankingsMenuControler rankingsMenuControler=new RankingsMenuControler(model);
        KeyStroke keyStroke= mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Escape);
        rankingsMenuControler.processKey(keyStroke);
        verify(model, times(1)).setRunning(false);
    }
}
