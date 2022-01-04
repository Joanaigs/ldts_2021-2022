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

    public void drawSymbol(){
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
    }

    @Override
    public void draw() throws IOException {
        drawSymbol();
        int y=12;
        int i = 0;
        //start
        for(MenuElement<MenuOption> menuElement:mainMenuModel.getOptions()){
            graphics.setForegroundColor(menuElement.getFillColor());
            graphics.putString((59-menuElement.getIdentifier().length())/2, y + i * 3, menuElement.getIdentifier(), SGR.BOLD);
            graphics.setForegroundColor(menuElement.getBorderColor());
            graphics.putString((59-menuElement.getIdentifier().length())/2, y+1 + i * 3, "-".repeat(menuElement.getIdentifier().length()), SGR.BLINK);
            i++;
        }
        screen.refresh();
    }
}
