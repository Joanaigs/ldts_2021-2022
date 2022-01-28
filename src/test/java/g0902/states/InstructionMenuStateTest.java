package g0902.states;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import g0902.Configuration;
import g0902.control.InstructionMenuController;
import g0902.gui.LanternaGUI;
import g0902.model.Menu.InstructionMenuModel;
import g0902.view.ViewInstructionMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.io.IOException;

import static org.mockito.Mockito.*;

public class InstructionMenuStateTest {
    ViewInstructionMenu view;
    InstructionMenuState state;
    InstructionMenuController controller;
    InstructionMenuModel model;
    LanternaGUI gui;

    @BeforeEach
    void setUp() {
        view=mock(ViewInstructionMenu.class);
        controller=mock(InstructionMenuController.class);
        model=mock(InstructionMenuModel.class);
        gui = mock(LanternaGUI.class);

        state=new InstructionMenuState(view, model, controller, gui);
    }

    @Test
    public void step() throws IOException {
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
    public void nextState(){
        State returned = state.nextState();
        Assertions.assertTrue(returned instanceof MainMenuState);
    }

    @Test
    void initScreen(){
        when(gui.getScreen()).thenReturn(Mockito.mock(Screen.class));
        state.initScreen();
        Mockito.verify(gui, times(1)).createScreenMenu();
    }

}
