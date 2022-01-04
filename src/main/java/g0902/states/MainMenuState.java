package g0902.states;

import g0902.control.MenuController;
import g0902.control.Observer;
import g0902.model.Menu.MainMenuModel;
import g0902.model.Model;
import g0902.view.ViewMainMenu;
import g0902.view.Viewer;

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
