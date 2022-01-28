package g0902.states;

import com.googlecode.lanterna.screen.Screen;
import g0902.Configuration;
import g0902.Music;
import g0902.control.RankingsMenuControler;
import g0902.gui.LanternaGUI;
import g0902.model.Menu.RankingsMenuModel;
import g0902.view.ViewRankingsMenu;
import org.junit.jupiter.api.AfterEach;
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
    LanternaGUI gui;
    Music music;

    @BeforeEach
    void setUp() throws IOException {
        view=mock(ViewRankingsMenu.class);
        controller=mock(RankingsMenuControler.class);
        model=mock(RankingsMenuModel.class);
        gui = mock(LanternaGUI.class);
        music=mock(Music.class);

        state=new RankingsMenuState(view, model, controller,music, gui);
        when(music.isPlaying()).thenReturn(true);
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

    @Test
    void initScreen(){
        when(gui.getScreen()).thenReturn(Mockito.mock(Screen.class));
        state.initScreen();
        Mockito.verify(gui, times(1)).createScreenMenu();
    }

    @Test
    void nextState(){
        State returned = state.nextState();
        Assertions.assertTrue(returned instanceof MainMenuState);
    }

    @Test
    void setStartMusic(){
        Mockito.when(music.isPlaying()).thenReturn(false);
        state.nextState();
        verify(music, times(0)).stop();
        verify(music, times(1)).isPlaying();
    }


    @Test
    void setStopMusic(){
        Mockito.when(music.isPlaying()).thenReturn(true);
        state.nextState();

        verify(music, times(1)).stop();
        verify(music, times(1)).isPlaying();
    }

}
