package g0902.states;

import g0902.Configuration;
import g0902.Music;
import g0902.control.Controller;
import g0902.control.MenuController;
import g0902.control.PacmanController;
import g0902.model.Game.GameModel;
import g0902.model.Game.Map.Map;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import g0902.view.ElementsView.GameView;
import g0902.view.ViewRankingsMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class GameStateTest {
    GameState state;
    GameView view;
    PacmanController controller;
    GameModel model;
    Pacman pacman;
    Map map;
    Music music;

    @BeforeEach
    void setUp(){
        view=mock(GameView.class);
        controller=mock(PacmanController.class);
        pacman=mock(Pacman.class);
        model=mock(GameModel.class);
        map=mock(Map.class);
        music=mock(Music.class);

        Mockito.when(model.getPacman()).thenReturn(pacman);
        when(map.getPacman()).thenReturn(pacman);
        when(controller.getPacman()).thenReturn(pacman);
        when(model.getMap()).thenReturn(map);
        when(pacman.getScore()).thenReturn(1000);
        when(pacman.getLives()).thenReturn(3);
        when(music.isPlaying()).thenReturn(true);
        state = Mockito.spy(new GameState(view, model, controller, music));
    }

    @Test
    void InsDrawTest() throws IOException {
        state.step();

        verify(music, times(0)).start();
        verify(music, times(1)).isPlaying();

        Mockito.verify(view, times(1)).draw();
        Assertions.assertEquals(view, state.getViewer());
        when(model.isRunning()).thenReturn(true);
        Assertions.assertEquals(true, state.isRunning());
        when(model.isRunning()).thenReturn(false);
        Assertions.assertEquals(false, state.isRunning());
        Assertions.assertEquals(controller, state.getObserver());
        Assertions.assertEquals(model, state.getModel());
    }


    @Test
    void nextLevelTest() throws IOException {
        Mockito.when(model.hasLost()).thenReturn(false);    // to enter else
        Mockito.doAnswer( invocation -> {
            state = new GameState(view, model, controller, music);
            return null;
        }).when(state).initializing();

       Configuration configuration = Mockito.mock(Configuration.class);
        try(MockedStatic<Configuration> configurationMockedStatic=Mockito.mockStatic(Configuration.class)){
            configurationMockedStatic.when(Configuration::getInstance).thenReturn(configuration);
            state.nextState();
            Assertions.assertEquals(3, ((GameModel)state.getModel()).getPacman().getLives());
            Assertions.assertEquals(1000, ((GameModel)state.getModel()).getPacman().getScore());
            Mockito.verify(configuration, times(1)).nextLevel();
        }
    }

}
