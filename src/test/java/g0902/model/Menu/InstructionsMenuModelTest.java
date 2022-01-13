package g0902.model.Menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InstructionsMenuModelTest {
    @Test
    public void runningTest(){
        InstructionMenuModel instructionMenuModel = new InstructionMenuModel();
        assertTrue(instructionMenuModel.isRunning());
        instructionMenuModel.setRunning(false);
        assertFalse(instructionMenuModel.isRunning());
    }
}
