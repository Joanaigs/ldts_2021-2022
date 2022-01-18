package g0902.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import g0902.model.Menu.MainMenuModel;
import g0902.model.Menu.Options.MenuElement;
import g0902.model.Menu.Options.MenuOption;

import java.io.IOException;

public class ViewMainMenu extends Viewer {
    final MainMenuModel mainMenuModel;

    public ViewMainMenu(MainMenuModel model, Screen screen) {
        super(model, screen);
        this.mainMenuModel=model;
    }

    public void drawSymbol(){
        String s1=" ___  ___  ___       __ __  ___  _ _ ";
        String s2="| . \\| . ||  _> ___ |  \\  \\| . || \\ |";
        String s3="|  _/|   || <__|___||     ||   ||   |";
        String s4="|_|  |_|_|`___/     |_|_|_||_|_||_\\_|";

        graphics.setForegroundColor(TextColor.Factory.fromString(Constants.YELLOW));//yellow
        graphics.putString(12, 4, s1);
        graphics.putString(12, 5, s2);
        graphics.putString(12, 6, s3);
        graphics.putString(12, 7, s4);

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
