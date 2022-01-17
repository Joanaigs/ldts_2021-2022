package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import g0902.model.Menu.InstructionMenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class InstructionMenuControllerTest {
    InstructionMenuModel model;
    InstructionMenuController controler;
    KeyStroke keyStroke;
    @BeforeEach
    void setUp(){
        model=mock(InstructionMenuModel.class);
        controler=new InstructionMenuController(model);
        keyStroke= mock(KeyStroke.class);
    }
    @Test
    public void test() {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Escape);
        controler.processKey(keyStroke);
        verify(model, times(1)).setRunning(false);
    }
}
