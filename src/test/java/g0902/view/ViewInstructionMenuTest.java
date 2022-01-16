package g0902.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Menu.InstructionMenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ViewInstructionMenuTest<T> {
    private Screen screen;
    private TextGraphics tg;
    ViewInstructionMenu view;
    InstructionMenuModel model;
    @BeforeEach
    void setUp() throws IOException {
        screen = mock(Screen.class);
        tg = mock(TextGraphics.class);
        model=mock(InstructionMenuModel.class);
        view= new ViewInstructionMenu(model, screen);
        view.setGraphics(tg);
    }

    @Test
    public void InsDrawTest() throws IOException {
        view.draw();
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#ffca18"));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#08ecd9"));
        Mockito.verify(tg, Mockito.times(1)).putString(anyInt(), anyInt(), anyString(),any(), any());
        Mockito.verify(tg, Mockito.times(14)).putString(anyInt(), anyInt(), anyString());
        Mockito.verify(tg, Mockito.times(1)).putString(20, 7, "      ___      ");
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }
}
