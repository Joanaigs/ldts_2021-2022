package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import g0902.model.Menu.InstructionMenuModel;

public class InstructionMenuController implements Observer{
    InstructionMenuModel instructionMenuModel;
    public InstructionMenuController(InstructionMenuModel instructionMenuModel) {
        this.instructionMenuModel=instructionMenuModel;}
    @Override
    public void processKey(KeyStroke key) {
        if(key.getKeyType() == KeyType.Enter){
            instructionMenuModel.setRunning(false);
        }
    }
}
