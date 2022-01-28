package g0902.control;

import g0902.states.MainMenuState;
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
    private Viewer nextViewer;
    private Controller controller;
    private ReadKeys readKeys;
    private MainMenuState nextState;

    @BeforeEach
    void setUp() throws IOException {
        state =mock(MainMenuState.class);
        viewer=mock(Viewer.class);
        nextViewer=mock(Viewer.class);
        nextState = mock(MainMenuState.class);
        controller=new Controller();
        readKeys=mock(ReadKeys.class);
        Mockito.doNothing().when(nextState).initScreen();

        Mockito.when(nextState.getViewer()).thenReturn(nextViewer);
        Mockito.when(state.getViewer()).thenReturn(viewer);
        Mockito.when(nextState.getViewer()).thenReturn(viewer);
        Mockito.when(state.nextState()).thenReturn(nextState);

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
        Mockito.verify(viewer, Mockito.times(2)).closeScreen();
        Mockito.verify(state, Mockito.times(1)).getViewer();
        Mockito.verify(viewer, Mockito.times(2)).getScreen();
        Mockito.verify(readKeys, Mockito.times(2)).setScreen(viewer.getScreen());
        Mockito.verify(readKeys, Mockito.times(2)).addObserver(state.getObserver());
        Mockito.verify(readKeys, Mockito.times(2)).removeObserver(state.getObserver());
    }

    @Test
    public void testEndScreen() throws IOException {
        controller.setState(state);
        controller.setReadKeys(readKeys);
        controller.run();
        Mockito.verify(state, Mockito.times(1)).isRunning();
        Mockito.verify(viewer, Mockito.times(2)).closeScreen();
        Mockito.verify(state, Mockito.times(1)).getViewer();
        Mockito.verify(viewer, Mockito.times(2)).getScreen();
    }
}
