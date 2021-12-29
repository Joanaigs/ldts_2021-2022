package control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import model.Menu.InstructionMenuModel;
import model.Menu.MainMenuModel;

import java.io.IOException;

public class InstructionMenuController implements Observer{
    InstructionMenuModel instructionMenuModel;
    InstructionMenuController(InstructionMenuModel instructionMenuModel) throws IOException {
        super();
        this.instructionMenuModel=instructionMenuModel;}
    @Override
    public void processKey(KeyStroke key) throws IOException, InterruptedException {
        if(key.getKeyType() == KeyType.Enter){
            instructionMenuModel.setRunning(false);
        }
    }
}
