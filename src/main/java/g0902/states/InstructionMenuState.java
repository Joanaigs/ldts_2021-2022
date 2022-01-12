package g0902.states;

import g0902.control.EndScreenControler;
import g0902.control.InstructionMenuController;
import g0902.control.Observer;
import g0902.gui.LanternaGUI;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Menu.InstructionMenuModel;
import g0902.model.Model;
import g0902.view.ViewInstructionMenu;
import g0902.view.Viewer;

import java.io.IOException;

public class InstructionMenuState extends State{
    ViewInstructionMenu viewInstructionMenu;
    InstructionMenuModel instructionMenuModel;
    InstructionMenuController instructionMenuController;
    LanternaGUI gui;
    private void initializing(){
        instructionMenuModel=new InstructionMenuModel();
        instructionMenuController=new InstructionMenuController(instructionMenuModel);
        gui=new LanternaGUI();
        gui.createScreenMenu();
    }

    public InstructionMenuState() throws IOException {
        super();
        initializing();
        viewInstructionMenu=new ViewInstructionMenu(instructionMenuModel, gui.getScreen());
    }
    //for testing only
    public InstructionMenuState(ViewInstructionMenu viewInstructionMenu){
        super();
        initializing();
        this.viewInstructionMenu=viewInstructionMenu;
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
    public void setViewer(Viewer viewer) {
        this.viewInstructionMenu= (ViewInstructionMenu) viewer;
    }

    @Override
    public void step() throws IOException {
        viewInstructionMenu.draw();
    }
}
