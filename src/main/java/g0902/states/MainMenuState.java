package g0902.states;

import g0902.control.EndScreenControler;
import g0902.control.MenuController;
import g0902.control.Observer;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Menu.MainMenuModel;
import g0902.model.Model;
import g0902.view.ViewMainMenu;
import g0902.view.Viewer;

import java.io.IOException;

public class MainMenuState extends State{
    private ViewMainMenu viewMainMenu;
    private MenuController menuController;
    private MainMenuModel mainMenuModel;

    private void initializing() throws IOException {
        mainMenuModel=new MainMenuModel();
        menuController=new MenuController(mainMenuModel);
    }
    public MainMenuState() throws IOException {
        super();
        initializing();
        viewMainMenu=new ViewMainMenu(mainMenuModel);
    }

    public MainMenuState(ViewMainMenu view) throws IOException {
        super();
        initializing();
        viewMainMenu=view;
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
    public void setViewer(Viewer viewer) {
        this.viewMainMenu= (ViewMainMenu) viewer;
    }

    @Override
    public void step() throws IOException {
        viewMainMenu.draw();
    }

}
