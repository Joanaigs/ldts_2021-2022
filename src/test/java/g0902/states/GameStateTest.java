package g0902.states;

import com.googlecode.lanterna.screen.Screen;
import g0902.Configuration;
import g0902.Music;
import g0902.control.Controller;
import g0902.control.MenuController;
import g0902.control.PacmanController;
import g0902.gui.LanternaGUI;
import g0902.model.Game.GameModel;
import g0902.model.Game.Map.Map;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import g0902.model.Menu.EndScreenModel;
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
    LanternaGUI gui;


    @BeforeEach
    void setUp(){
        view=mock(GameView.class);
        controller=mock(PacmanController.class);
        pacman=mock(Pacman.class);
        model=mock(GameModel.class);
        map=mock(Map.class);
        music=mock(Music.class);
        gui = mock(LanternaGUI.class);
        state = Mockito.spy(new GameState(view, model, controller, music, gui));

        Mockito.when(model.getPacman()).thenReturn(pacman);
        when(map.getPacman()).thenReturn(pacman);
        when(controller.getPacman()).thenReturn(pacman);
        when(model.getMap()).thenReturn(map);
        when(pacman.getScore()).thenReturn(1000);
        when(pacman.getLives()).thenReturn(3);
        when(music.isPlaying()).thenReturn(true);
    }

    @Test
    void update() throws IOException {
        state = Mockito.spy(state);
        Mockito.doReturn(40L).when(state).getTimePassed();
        state.step();
        Mockito.verify(model, times(2)).update(20);

    }

    @Test
    void setStopMusic() throws IOException {
        Mockito.when(music.isPlaying()).thenReturn(true);
        state.step();

        verify(music, times(1)).stop();
        verify(music, times(1)).isPlaying();
    }

    @Test
    void setStartMusic() throws IOException {
        Mockito.when(music.isPlaying()).thenReturn(false);
        state.step();
        verify(music, times(0)).stop();
        verify(music, times(1)).isPlaying();
    }
    @Test
    void step() throws IOException {
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

    @Test
    void frightenedMusicPlaying() throws IOException {
        Configuration configuration = Mockito.mock(Configuration.class);
        Music frightenedMusic = mock(Music.class);
        when(configuration.getFrightenedModeMusic()).thenReturn(frightenedMusic);
        try (MockedStatic<Configuration> configurationMockedStatic = Mockito.mockStatic(Configuration.class)) {
            configurationMockedStatic.when(Configuration::getInstance).thenReturn(configuration);
            Mockito.when(frightenedMusic.isPlaying()).thenReturn(true);
            state.nextState();
            verify(frightenedMusic, times(1)).stop();
            verify(frightenedMusic, times(1)).isPlaying();
        }
    }

    @Test
    void frightenedMusicNotPlaying() throws IOException {
        Configuration configuration = Mockito.mock(Configuration.class);
        Music frightenedMusic = mock(Music.class);
        when(configuration.getFrightenedModeMusic()).thenReturn(frightenedMusic);
        try (MockedStatic<Configuration> configurationMockedStatic = Mockito.mockStatic(Configuration.class)) {
            configurationMockedStatic.when(Configuration::getInstance).thenReturn(configuration);
            Mockito.when(frightenedMusic.isPlaying()).thenReturn(false);
            state.nextState();
            verify(frightenedMusic, times(0)).stop();
            verify(frightenedMusic, times(1)).isPlaying();
        }
    }

    @Test
    void hasLost() throws IOException {
        Mockito.when(model.hasLost()).thenReturn(true);    // to enter else
        Mockito.doNothing().when(state).initializing();

        Configuration configuration = Mockito.mock(Configuration.class);
        when(configuration.getFrightenedModeMusic()).thenReturn(mock(Music.class));
        try(MockedStatic<Configuration> configurationMockedStatic=Mockito.mockStatic(Configuration.class)){
            configurationMockedStatic.when(Configuration::getInstance).thenReturn(configuration);
            State returned = state.nextState();
            Mockito.verify(configuration, never()).nextLevel();
            Assertions.assertTrue(returned instanceof EndScreenState);
            EndScreenModel endScreenModel = ((EndScreenModel) returned.getModel());
            Assertions.assertEquals(1000, endScreenModel.getScore());
            Assertions.assertTrue(endScreenModel.hasLost());
        }
    }

    @Test
    void didNotLost() throws IOException {
        Mockito.when(model.hasLost()).thenReturn(false);    // to enter else
        Mockito.doNothing().when(state).initializing();

       Configuration configuration = Mockito.mock(Configuration.class);
       when(configuration.getFrightenedModeMusic()).thenReturn(mock(Music.class));
        try(MockedStatic<Configuration> configurationMockedStatic=Mockito.mockStatic(Configuration.class)){
            configurationMockedStatic.when(Configuration::getInstance).thenReturn(configuration);
            State returned = state.nextState();
            Mockito.verify(state, times(1)).initializing();
            Assertions.assertEquals(3, ((GameModel)state.getModel()).getPacman().getLives());
            Assertions.assertEquals(1000, ((GameModel)state.getModel()).getPacman().getScore());
            Mockito.verify(configuration, times(1)).nextLevel();
            Mockito.verify(pacman, times(1)).setScore(1000);
            Mockito.verify(pacman, times(1)).setLives(3);
            Mockito.verify(model, times(1)).setPacman(pacman);
            Assertions.assertEquals(state, returned);
            Assertions.assertEquals(49, state.getLevels());

        }
    }


    @Test
    void initScreen(){
        when(gui.getScreen()).thenReturn(Mockito.mock(Screen.class));
        state.initScreen();
        Mockito.verify(gui, times(1)).createScreenGame();
    }


}
