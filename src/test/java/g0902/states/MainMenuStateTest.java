package g0902.states;

import com.googlecode.lanterna.screen.Screen;
import g0902.Configuration;
import g0902.Music;
import g0902.control.MenuController;
import g0902.gui.LanternaGUI;
import g0902.model.Menu.MainMenuModel;
import g0902.view.ViewMainMenu;
import org.junit.jupiter.api.AfterEach;
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
    Music music;
    LanternaGUI gui;

    @BeforeEach
    void setUp() {
        view=mock(ViewMainMenu.class);
        controller=mock(MenuController.class);
        model=mock(MainMenuModel.class);
        music=mock(Music.class);
        gui = mock(LanternaGUI.class);


        when(music.isPlaying()).thenReturn(false);
        state=new MainMenuState(view, model, controller, music, gui);
    }

    @Test
    public void step() throws IOException {
        state.step();

        verify(music, times(1)).start();
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
    void initScreen(){
        when(gui.getScreen()).thenReturn(Mockito.mock(Screen.class));
        state.initScreen();
        Mockito.verify(gui, times(1)).createScreenMenu();
    }

    @Test
    public void nextState() throws IOException {
        Mockito.when(model.getSelected()).thenReturn("START", "INSTRUCTIONS",  "LEADERBOARD");
        State returned =  state.nextState();
        Assertions.assertTrue(returned instanceof GameState);
        returned =  state.nextState();
        Assertions.assertTrue(returned instanceof  InstructionMenuState);
        returned =  state.nextState();
        Assertions.assertTrue(returned instanceof RankingsMenuState);
    }

}
