package g0902.states;

import g0902.control.InstructionMenuController;
import g0902.control.Observer;
import g0902.gui.LanternaGUI;
import g0902.model.Menu.InstructionMenuModel;
import g0902.model.Model;
import g0902.view.ViewInstructionMenu;
import g0902.view.Viewer;

import java.io.IOException;

public class InstructionMenuState extends State{
    final ViewInstructionMenu viewInstructionMenu;
    final InstructionMenuModel instructionMenuModel;
    final InstructionMenuController instructionMenuController;
    LanternaGUI gui;

    public InstructionMenuState(){
        super();
        instructionMenuModel=new InstructionMenuModel();
        instructionMenuController=new InstructionMenuController(instructionMenuModel);
        gui=new LanternaGUI();
        gui.createScreenMenu();
        viewInstructionMenu=new ViewInstructionMenu(instructionMenuModel, gui.getScreen());
    }
    //for testing only
    public InstructionMenuState(ViewInstructionMenu viewInstructionMenu, InstructionMenuModel model, InstructionMenuController controller){
        super();
        instructionMenuModel=model;
        instructionMenuController=controller;
        this.viewInstructionMenu=viewInstructionMenu;
    }

    @Override
    public Viewer getViewer() {return viewInstructionMenu;}

    @Override
    public Observer getObserver() {return instructionMenuController;}

    @Override
    public Model getModel() {
        return instructionMenuModel;
    }

    @Override
    public boolean isRunning() {
        return instructionMenuModel.isRunning();
    }

    @Override
    public void step() throws IOException {
        viewInstructionMenu.draw();
    }

    @Override
    public State nextState() {return new MainMenuState();}
}
