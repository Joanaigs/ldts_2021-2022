package g0902.states;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import g0902.control.InstructionMenuController;
import g0902.control.MenuController;
import g0902.model.Menu.InstructionMenuModel;
import g0902.model.Menu.MainMenuModel;
import g0902.view.ViewInstructionMenu;
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
    @BeforeEach
    void setUp() {
        view=mock(ViewInstructionMenu.class);
        controller=mock(InstructionMenuController.class);
        model=mock(InstructionMenuModel.class);
        state=new InstructionMenuState(view, model, controller);
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
