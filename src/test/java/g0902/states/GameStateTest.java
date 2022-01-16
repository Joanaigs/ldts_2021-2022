package g0902.states;

import g0902.control.MenuController;
import g0902.control.PacmanController;
import g0902.model.Game.GameModel;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import g0902.model.Menu.MainMenuModel;
import g0902.view.ElementsView.GameView;
import g0902.view.ViewRankingsMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class GameStateTest {
    GameState state;
    GameView view;
    PacmanController controller;
    GameModel model;
    @BeforeEach
    void setUp() throws IOException {
        view=mock(GameView.class);
        controller=mock(PacmanController.class);
        Pacman pacman=mock(Pacman.class);
        when(controller.getPacman()).thenReturn(pacman);
        when(pacman.getScore()).thenReturn(1000);
        model=mock(GameModel.class);
        state=new GameState(view, model, controller);
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
