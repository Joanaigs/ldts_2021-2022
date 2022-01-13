package g0902.control;

import com.googlecode.lanterna.TextColor;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Menu.MainMenuModel;
import g0902.states.EndScreenState;
import g0902.states.MainMenuState;
import g0902.states.State;
import g0902.view.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class ControllerTest {
    MainMenuState state;
    Viewer viewer;
    Controller controller;
    ReadKeys readKeys;
    @BeforeEach
    void setUp() throws IOException {
        state =mock(MainMenuState.class);
        viewer=mock(Viewer.class);
        readKeys=mock(ReadKeys.class);
        Mockito.when(state.getViewer()).thenReturn(viewer);
        controller=new Controller();
        controller.setState(state);
        controller.setReadKeys(readKeys);
        controller.run();
    }
    @Test
    public void testMainMenu() throws IOException {
        Mockito.verify(state, Mockito.times(1)).isRunning();
        Mockito.verify(viewer, Mockito.times(1)).closeScreen();
        Mockito.verify(state, Mockito.times(1)).getViewer();
        Mockito.verify(viewer, Mockito.times(1)).getScreen();
        Mockito.verify(readKeys, Mockito.times(1)).setScreen(viewer.getScreen());
        Mockito.verify(readKeys, Mockito.times(1)).addObserver(state.getObserver());
        Mockito.verify(readKeys, Mockito.times(1)).removeObserver(state.getObserver());
    }
    @Test
    public void testEndScreen() throws IOException {
        Mockito.verify(state, Mockito.times(1)).isRunning();
        Mockito.verify(viewer, Mockito.times(1)).closeScreen();
        Mockito.verify(state, Mockito.times(1)).getViewer();
        Mockito.verify(viewer, Mockito.times(1)).getScreen();
    }
}
