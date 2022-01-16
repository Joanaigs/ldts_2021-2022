package g0902.states;

import g0902.control.RankingsMenuControler;
import g0902.model.Menu.RankingsMenuModel;
import g0902.view.ViewMainMenu;
import g0902.view.ViewRankingsMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class RankingsMenuStateTest {
    RankingsMenuState state;
    ViewRankingsMenu view;
    RankingsMenuControler controller;
    RankingsMenuModel model;
    @BeforeEach
    void setUp() throws IOException {
        view=mock(ViewRankingsMenu.class);
        controller=mock(RankingsMenuControler.class);
        model=mock(RankingsMenuModel.class);
        state=new RankingsMenuState(view, model, controller);
    }

    @Test
    public void stepTest() throws IOException {
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
