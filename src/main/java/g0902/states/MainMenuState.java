package g0902.states;


import g0902.Configuration;
import g0902.control.MenuController;
import g0902.Music;
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
    Music music;

    public MainMenuState(){
        super();
        mainMenuModel=new MainMenuModel();
        menuController=new MenuController(mainMenuModel);
        gui=new LanternaGUI();
        gui.createScreenMenu();
        viewMainMenu=new ViewMainMenu(mainMenuModel, gui.getScreen());
        music = Configuration.getInstance().getMenuMusic();
    }
    //for test use only
    public MainMenuState(ViewMainMenu view, MainMenuModel model, MenuController controler, Music music){
        super();
        mainMenuModel=model;
        menuController=controler;
        viewMainMenu=view;
        this.music=music;
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
    public void step() throws IOException {
        viewMainMenu.draw();
        if(!music.isPlaying())
            music.start();
    }

    @Override
    public State nextState() throws IOException {
        switch (mainMenuModel.getSelected()) {
            case "START":
                return new GameState();
            case "INSTRUCTIONS":
                return new InstructionMenuState();
            case "LEADERBOARD":
                return new RankingsMenuState();
            case "EXIT":
                exit(0);
                break;
        }

        return null;
    }

}
