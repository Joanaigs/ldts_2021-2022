package g0902.states;

import g0902.view.ViewEndScreen;
import g0902.view.ViewMainMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class MainMenuStateTest {
    MainMenuState state;
    ViewMainMenu view;
    @BeforeEach
    void setUp() throws IOException {
        view=mock(ViewMainMenu.class);
        state=new MainMenuState(view);
    }

    @Test
    public void InsDrawTest() throws IOException {
        state.step();
        Mockito.verify(view, times(1)).draw();
        Assertions.assertEquals(view, state.getViewer());
        Assertions.assertEquals(true, state.isRunning());
    }
}
