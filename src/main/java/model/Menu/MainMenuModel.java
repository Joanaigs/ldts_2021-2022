package model.Menu;

import com.googlecode.lanterna.TextColor;
import model.Menu.Options.MenuOption;
import model.Menu.Options.MenuElement;
import model.Model;

import java.util.ArrayList;
import java.util.List;


public class MainMenuModel implements Model {
    List<MenuElement<MenuOption>> options;
    int selected;

    public MainMenuModel() {
        options = new ArrayList<>();
        for(MenuOption temp: MenuOption.values()){
            options.add(new MenuElement(temp, new TextColor.RGB(255, 255, 255), new TextColor.RGB(255, 255, 255)));
        }
        this.selected = 0;
    }


    public void selectPrevious(){
        if(this.selected > 0){
            options.get(this.selected).deselect();
            this.selected--;
            options.get(this.selected).select();
        }
    }

    public void selectNext(){
        if(this.selected<options.size()-1){
            options.get(this.selected).deselect();
            this.selected++;
            options.get(this.selected).select();
        }
    }

    public String getSelected() {
        return options.get(selected).getIdentifier().toString();
    }

    public List<MenuElement<MenuOption>> getOptions(){return options;}
}
