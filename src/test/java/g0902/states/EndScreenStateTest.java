package g0902.states;


import com.googlecode.lanterna.screen.Screen;
import g0902.Configuration;
import g0902.Music;
import g0902.control.EndScreenControler;
import g0902.gui.LanternaGUI;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Menu.RankingsMenuModel;
import g0902.view.ViewEndScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class EndScreenStateTest {
    ViewEndScreen view;
    EndScreenState state;
    EndScreenModel model;
    EndScreenControler controller;
    Music music;
    LanternaGUI gui;

    @BeforeEach
    void setUp() {
        view=mock(ViewEndScreen.class);
        gui = mock(LanternaGUI.class);
        model=mock(EndScreenModel.class);
        controller=mock(EndScreenControler.class);
        music=mock(Music.class);

        when(music.isPlaying()).thenReturn(true);
        state=new EndScreenState(view, model, controller, music, gui);
        when(model.getName()).thenReturn("nome");
        when(model.getScore()).thenReturn(200);
    }

    @Test
    public void step() throws IOException {
        Configuration config = Mockito.mock(Configuration.class);
        try (MockedStatic<Configuration> configurationMockedStatic = Mockito.mockStatic(Configuration.class)) {
            configurationMockedStatic.when(Configuration::getInstance).thenReturn(config);
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

            Mockito.verify(config, times(2)).stopGameMusic();
        }
    }

    @Test
    void nextState() throws IOException {
        State returned = state.nextState();
        Assertions.assertTrue(returned instanceof RankingsMenuState);
        boolean createsPair = false;
        for(var pair: (  ((RankingsMenuModel)((RankingsMenuState)returned).getModel()).getScores())) {
            if (pair.getL().equals("nome") && pair.getR().equals(200)) {
                createsPair = true;
                break;
            }
        }
        Assertions.assertTrue(createsPair);
    }

    @Test
    void initScreen(){
        when(gui.getScreen()).thenReturn(Mockito.mock(Screen.class));
        state.initScreen();
        Mockito.verify(gui, times(1)).createScreenMenu();
    }

}
