package g0902.control;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Menu.MainMenuModel;
import g0902.states.EndScreenState;
import g0902.states.MainMenuState;
import g0902.states.State;
import g0902.view.ViewMainMenu;
import g0902.view.Viewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class ControllerTest {
    private MainMenuState state;
    private Viewer viewer;
    private Controller controller;
    private ReadKeys readKeys;

    @BeforeEach
    void setUp() throws IOException {
        state =mock(MainMenuState.class);
        viewer=mock(Viewer.class);
        readKeys=mock(ReadKeys.class);
        Mockito.when(state.getViewer()).thenReturn(viewer);
        controller=new Controller();
    }

    @Test
    public void controllerTest(){
        Assertions.assertTrue(controller.getThread().isAlive());
        controller.getReadKeys().setScreen(viewer.getScreen());
        Assertions.assertEquals(viewer.getScreen(), controller.getReadKeys().getScreen());
        Assertions.assertEquals(0, controller.getReadKeys().getObservers().size());
        Observer observerMock = mock(Observer.class);
        controller.getReadKeys().addObserver(observerMock);
        Assertions.assertEquals(1, controller.getReadKeys().getObservers().size());
    }

    @Test
    public void testMainMenu() throws IOException {
        controller.setState(state);
        controller.setReadKeys(readKeys);
        controller.run();
        Mockito.verify(state, Mockito.times(1)).isRunning();
        Mockito.verify(state, Mockito.times(1)).nextState();
        Mockito.verify(viewer, Mockito.times(1)).closeScreen();
        Mockito.verify(state, Mockito.times(1)).getViewer();
        Mockito.verify(viewer, Mockito.times(1)).getScreen();
        Mockito.verify(readKeys, Mockito.times(1)).setScreen(viewer.getScreen());
        Mockito.verify(readKeys, Mockito.times(1)).addObserver(state.getObserver());
        Mockito.verify(readKeys, Mockito.times(1)).removeObserver(state.getObserver());
    }

    @Test
    public void testEndScreen() throws IOException {
        controller.setState(state);
        controller.setReadKeys(readKeys);
        controller.run();
        Mockito.verify(state, Mockito.times(1)).isRunning();
        Mockito.verify(viewer, Mockito.times(1)).closeScreen();
        Mockito.verify(state, Mockito.times(1)).getViewer();
        Mockito.verify(viewer, Mockito.times(1)).getScreen();
    }
}
