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
    private final MenuController menuController;
    private final MainMenuModel mainMenuModel;
    LanternaGUI gui;
    Music music;

    public MainMenuState(){
        super();
        mainMenuModel=new MainMenuModel();
        menuController=new MenuController(mainMenuModel);
        gui=new LanternaGUI();
        music = Configuration.getInstance().getMenuMusic();
    }
    //for test use only
    public MainMenuState(ViewMainMenu view, MainMenuModel model, MenuController controler, Music music, LanternaGUI gui){
        super();
        mainMenuModel=model;
        menuController=controler;
        viewMainMenu=view;
        this.music=music;
        this.gui= gui;
    }

    @Override
    public void initScreen(){
        gui.createScreenMenu();
        viewMainMenu=new ViewMainMenu(mainMenuModel, gui.getScreen());
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
