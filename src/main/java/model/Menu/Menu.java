package model.Menu;


import model.Model;

public class Menu implements Model {
    public enum Option {START, RANKING, SETTINGS, INSTRUCTIONS, EXIT}
    public String[] optStr = {"NEW GAME", "INSTRUCTIONS", "SETTINGS", "RANKINGS", "EXIT"};

    Option selected;
    Option[] saved;


    public Menu(boolean inGame) {

    }

    public Option getSelected() {
        return selected;
    }





}
