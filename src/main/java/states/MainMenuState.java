package states;

import control.Controller;
import control.InstructionMenuController;
import control.MenuController;
import control.Observer;
import model.Menu.InstructionMenuModel;
import model.Menu.MainMenuModel;
import model.Model;
import view.ViewMainMenu;
import view.Viewer;

import java.io.IOException;

public class MainMenuState extends State{
    private ViewMainMenu viewMainMenu;
    private MenuController menuController;
    private MainMenuModel mainMenuModel;
    public MainMenuState() throws IOException {
        super();
        mainMenuModel=new MainMenuModel();
        menuController=new MenuController(mainMenuModel);
        viewMainMenu=new ViewMainMenu(mainMenuModel);
    }

    @Override
    public Viewer getViewer() {
        return viewMainMenu;
    }


    @Override
    public Observer getObserver() throws IOException {
        return menuController;
    }

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
    public void step() throws IOException {
        viewMainMenu.draw();
    }

}
