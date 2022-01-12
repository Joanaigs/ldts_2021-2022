package g0902.states;


import g0902.control.MenuController;
import g0902.control.Observer;
import g0902.gui.LanternaGUI;
import g0902.model.Menu.MainMenuModel;
import g0902.model.Model;
import g0902.view.ViewMainMenu;
import g0902.view.Viewer;

import java.io.IOException;

import static java.lang.System.exit;

public class MainMenuState extends State{
    private ViewMainMenu viewMainMenu;
    private MenuController menuController;
    private MainMenuModel mainMenuModel;
    LanternaGUI gui;

    private void initializing() {
        mainMenuModel=new MainMenuModel();
        menuController=new MenuController(mainMenuModel);
        gui=new LanternaGUI();
        gui.createScreenMenu();
    }
    public MainMenuState(){
        super();
        initializing();
        viewMainMenu=new ViewMainMenu(mainMenuModel, gui.getScreen());
    }

    public MainMenuState(ViewMainMenu view){
        super();
        initializing();
        viewMainMenu=view;
    }
    @Override
    public Viewer getViewer() {
        return viewMainMenu;
    }

    @Override
    public Observer getObserver(){return menuController;}

    @Override
    public Model getModel() {
        return mainMenuModel;
    }

    @Override
    public boolean isRunning() {
        return mainMenuModel.isRunning();
    }

    @Override
    public String getString(){
        return "mainMenu";
    }

    @Override
    public void setViewer(Viewer viewer) {
        this.viewMainMenu= (ViewMainMenu) viewer;
    }

    @Override
    public void step() throws IOException {
        viewMainMenu.draw();
    }

    @Override
    public State nextState() throws IOException {
        switch (mainMenuModel.getSelected()) {
            case "START":
                return new GameState();
            case "INSTRUCTIONS":
                return new InstructionMenuState();
            case "RANKINGS":
                return new RankingsMenuState();
            case "EXIT":
                exit(0);
                break;
        }

        return null;
    }
}
