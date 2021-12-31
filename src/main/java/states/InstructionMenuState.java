package states;

import control.Controller;
import control.InstructionMenuController;
import control.Observer;
import model.Menu.InstructionMenuModel;
import model.Model;
import view.ViewInstructionMenu;
import view.Viewer;

import java.io.IOException;

public class InstructionMenuState extends State{
    ViewInstructionMenu viewInstructionMenu;
    InstructionMenuModel instructionMenuModel;
    InstructionMenuController instructionMenuController;
    public InstructionMenuState() throws IOException {
        super();
        instructionMenuModel=new InstructionMenuModel();
        viewInstructionMenu=new ViewInstructionMenu(instructionMenuModel);
        instructionMenuController=new InstructionMenuController(instructionMenuModel);
    }

    @Override
    public Viewer getViewer() {
        return viewInstructionMenu;
    }


    @Override
    public Observer getObserver() throws IOException {
        return instructionMenuController;
    }

    @Override
    public Model getModel() {
        return instructionMenuModel;
    }

    @Override
    public boolean isRunning() {
        return instructionMenuModel.isRunning();
    }

    @Override
    public String getString() {
        return "InstructionMenu";
    }

    @Override
    public void step() throws IOException {
        viewInstructionMenu.draw();
    }
}
