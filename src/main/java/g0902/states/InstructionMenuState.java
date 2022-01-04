package g0902.states;

import g0902.control.InstructionMenuController;
import g0902.control.Observer;
import g0902.model.Menu.InstructionMenuModel;
import g0902.model.Model;
import g0902.view.ViewInstructionMenu;
import g0902.view.Viewer;

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
