package g0902.control;

import g0902.model.Menu.InstructionMenuModel;
import g0902.model.Menu.MainMenuModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ReadKeysTest {
    ReadKeys readKeys;
    InstructionMenuController instructionMenuController;
    MenuController menuController;
    @BeforeEach
    void setUp() {
        menuController=new MenuController(new MainMenuModel());
        instructionMenuController=new InstructionMenuController(new InstructionMenuModel());
        readKeys=new ReadKeys();
        readKeys.addObserver(menuController);
        readKeys.addObserver(instructionMenuController);
    }
    @Test
    public void addObserver(){
        Assertions.assertEquals(2,readKeys.getObservers().size());
    }
    @Test
    public void RemoveObserver() {
        readKeys.removeObserver(instructionMenuController);
        Assertions.assertEquals(1,readKeys.getObservers().size());
        Assertions.assertEquals(menuController,readKeys.getObservers().get(0));
    }
}
