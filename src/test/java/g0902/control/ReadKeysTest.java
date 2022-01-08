package g0902.control;

import g0902.model.Menu.InstructionMenuModel;
import g0902.model.Menu.MainMenuModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ReadKeysTest {
    @Test
    public void addObserver() throws IOException {
        MenuController menuController=new MenuController(new MainMenuModel());
        InstructionMenuController instructionMenuController=new InstructionMenuController(new InstructionMenuModel());
        ReadKeys readKeys=new ReadKeys();
        readKeys.addObserver(menuController);
        readKeys.addObserver(instructionMenuController);
        Assertions.assertEquals(2,readKeys.getObservers().size());
    }
    @Test
    public void RemoveObserver() throws IOException {
        MenuController menuController=new MenuController(new MainMenuModel());
        InstructionMenuController instructionMenuController=new InstructionMenuController(new InstructionMenuModel());
        ReadKeys readKeys=new ReadKeys();
        readKeys.addObserver(menuController);
        readKeys.addObserver(instructionMenuController);
        readKeys.removeObserver(instructionMenuController);
        Assertions.assertEquals(1,readKeys.getObservers().size());
        Assertions.assertEquals(menuController,readKeys.getObservers().get(0));
    }
}
