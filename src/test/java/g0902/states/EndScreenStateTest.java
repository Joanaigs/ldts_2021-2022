package g0902.states;


import g0902.control.EndScreenControler;
import g0902.control.MenuController;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Menu.MainMenuModel;
import g0902.view.ViewEndScreen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class EndScreenStateTest {
    ViewEndScreen view;
    EndScreenState state;
    EndScreenModel model;
    EndScreenControler controller;
    @BeforeEach
    void setUp() throws IOException {
        view=mock(ViewEndScreen.class);
        model=mock(EndScreenModel.class);
        controller=mock(EndScreenControler.class);
        state=new EndScreenState(view, model, controller);
    }

    @Test
    public void Test() throws IOException {
        state.step();
        Mockito.verify(view, times(1)).draw();
        Assertions.assertEquals(view, state.getViewer());
        when(model.isRunning()).thenReturn(true);
        Assertions.assertEquals(true, state.isRunning());
        when(model.isRunning()).thenReturn(false);
        Assertions.assertEquals(false, state.isRunning());
        Assertions.assertEquals(controller, state.getObserver());
        Assertions.assertEquals(model, state.getModel());

    }
}
