package model.Menu;

import com.googlecode.lanterna.TextColor;
import model.Menu.Options.MenuElement;
import model.Menu.Options.MenuOptions;
import model.Model;

import java.util.ArrayList;
import java.util.List;


public class MainMenuModel implements Model {
    List<MenuElement> options;
    int selected;

    public MainMenuModel() {
        options = new ArrayList<>();
        for(MenuOptions temp: MenuOptions.values()){
            options.add(new MenuElement(temp.getText(), new TextColor.RGB(255, 255, 255), new TextColor.RGB(255, 255, 255)));
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
        return options.get(selected).getIdentifier();
    }
}
