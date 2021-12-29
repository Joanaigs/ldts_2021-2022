package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import model.Menu.MainMenuModel;
import model.Menu.Options.MenuElement;
import model.Menu.Options.MenuOption;

import java.io.IOException;
import java.util.List;

public class ViewMainMenu extends ViewerMenu<MainMenuModel>{
    MainMenuModel mainMenuModel;
    public ViewMainMenu(MainMenuModel model) {
        super(model);
        this.mainMenuModel=model;
    }

    @Override
    public void draw() throws IOException {
        String s1=" _ __   __ _  ___ _ __ ___   __ _ _ __ ";
        String s2="| '_ \\ / _` |/ __| '_ ` _ \\ / _` | '_ \\";
        String s3="| |_) | (_| | (__| | | | | | (_| | | | |";
        String s4="| .__/ \\__,_|\\___|_| |_| |_|\\__,_|_| |_|";
        String s5="| | ";
        String s6="|_|  ";


        graphics.setForegroundColor(TextColor.Factory.fromString("#ffca18"));//yellow
        graphics.putString(10, 2, s1);
        graphics.putString(10, 3, s2);
        graphics.putString(10, 4, s3);
        graphics.putString(10, 5, s4);
        graphics.putString(10, 6, s5);
        graphics.putString(10, 7, s6);


        int x=30;
        int y=12;
        int i = 0;
        List<MenuElement<MenuOption>> options=mainMenuModel.getOptions();
        MenuElement<MenuOption> menuElement=options.get(0);
        //start
        graphics.setForegroundColor(menuElement.getFillColor());
        graphics.putString(26, y + i * 3, menuElement.getIdentifier(), SGR.BOLD);
        graphics.setForegroundColor(menuElement.getBorderColor());
        graphics.putString(26, y+1 + i * 3, "-".repeat(menuElement.getIdentifier().length()), SGR.BLINK);
        i++;
        //INSTRUCTIONS
        menuElement=options.get(1);
        graphics.setForegroundColor(menuElement.getFillColor());
        graphics.putString(23, y + i * 3, menuElement.getIdentifier(), SGR.BOLD);
        graphics.setForegroundColor(menuElement.getBorderColor());
        graphics.putString(23, y+1 + i * 3, "-".repeat(menuElement.getIdentifier().length()), SGR.BLINK);
        i++;
        //RANKINGS
        menuElement=options.get(2);
        graphics.setForegroundColor(menuElement.getFillColor());
        graphics.putString(25, y + i * 3, menuElement.getIdentifier(), SGR.BOLD);
        graphics.setForegroundColor(menuElement.getBorderColor());
        graphics.putString(25, y+1 + i * 3, "-".repeat(menuElement.getIdentifier().length()), SGR.BLINK);
        i++;
        //EXIT
        menuElement=options.get(3);
        graphics.setForegroundColor(menuElement.getFillColor());
        graphics.putString(27, y + i * 3, menuElement.getIdentifier(), SGR.BOLD);
        graphics.setForegroundColor(menuElement.getBorderColor());
        graphics.putString(27, y+1 + i * 3, "-".repeat(menuElement.getIdentifier().length()), SGR.BLINK);
        i++;
        screen.refresh();
    }
}
