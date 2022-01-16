package g0902.states;

import g0902.control.MenuController;
import g0902.control.RankingsMenuControler;
import g0902.model.Menu.MainMenuModel;
import g0902.model.Menu.RankingsMenuModel;
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
    MenuController controller;
    MainMenuModel model;
    @BeforeEach
    void setUp() throws IOException {
        view=mock(ViewMainMenu.class);
        controller=mock(MenuController.class);
        model=mock(MainMenuModel.class);
        state=new MainMenuState(view, model, controller);
    }

    @Test
    public void InsDrawTest() throws IOException {
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
