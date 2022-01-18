package g0902.states;


import g0902.Configuration;
import g0902.Music;
import g0902.control.EndScreenControler;
import g0902.control.MenuController;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Menu.MainMenuModel;
import g0902.view.ViewEndScreen;
import org.junit.jupiter.api.AfterEach;
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
    Music music;
    @BeforeEach
    void setUp() throws IOException {
        view=mock(ViewEndScreen.class);
        model=mock(EndScreenModel.class);
        controller=mock(EndScreenControler.class);
        music=mock(Music.class);
        when(music.isPlaying()).thenReturn(true);
        state=new EndScreenState(view, model, controller, music);
    }

    @Test
    public void Test() throws IOException {
        state.step();
        verify(music, times(0)).start();
        when(music.isPlaying()).thenReturn(false);
        state.setMusic(music);
        state.step();
        verify(music, times(1)).start();
        verify(music, times(2)).isPlaying();

        Mockito.verify(view, times(2)).draw();
        Assertions.assertEquals(view, state.getViewer());
        when(model.isRunning()).thenReturn(true);
        Assertions.assertEquals(true, state.isRunning());
        when(model.isRunning()).thenReturn(false);
        Assertions.assertEquals(false, state.isRunning());
        Assertions.assertEquals(controller, state.getObserver());
        Assertions.assertEquals(model, state.getModel());

    }

}
