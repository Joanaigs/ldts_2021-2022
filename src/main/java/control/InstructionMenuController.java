package control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import model.Menu.InstructionMenuModel;
import model.Menu.MainMenuModel;

import java.io.IOException;

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
