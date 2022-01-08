package g0902.control;

import com.googlecode.lanterna.TextColor;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Menu.MainMenuModel;
import g0902.states.EndScreenState;
import g0902.states.MainMenuState;
import g0902.states.State;
import g0902.view.Viewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class ControllerTest {
    @Test
    public void testMainMenu() throws IOException {
        MainMenuState state =mock(MainMenuState.class);
        Viewer viewer=mock(Viewer.class);
        Mockito.when(state.getViewer()).thenReturn(viewer);
        Controller controller=new Controller();
        controller.setState(state);
        controller.run();
        Mockito.verify(state, Mockito.times(1)).isRunning();
        Mockito.verify(viewer, Mockito.times(1)).closeScreen();
        Mockito.verify(state, Mockito.times(1)).getViewer();
        Mockito.verify(viewer, Mockito.times(1)).getScreen();
    }
    @Test
    public void testEndScreen() throws IOException {
        EndScreenState state =mock(EndScreenState.class);
        Viewer viewer=mock(Viewer.class);
        Mockito.when(state.getViewer()).thenReturn(viewer);
        Controller controller=new Controller();
        controller.setState(state);
        controller.run();
        Mockito.verify(state, Mockito.times(1)).isRunning();
        Mockito.verify(viewer, Mockito.times(1)).closeScreen();
        Mockito.verify(state, Mockito.times(1)).getViewer();
        Mockito.verify(viewer, Mockito.times(1)).getScreen();
    }
}
