package g0902.model.Menu;

import com.googlecode.lanterna.TextColor;
import g0902.model.Menu.Options.MenuOption;
import g0902.model.Menu.Options.MenuElement;
import g0902.model.Model;

import java.util.ArrayList;
import java.util.List;


public class MainMenuModel implements Model, MenuModel {
    private final List<MenuElement<MenuOption>> options;
    private int selected;
    private boolean running;

    public MainMenuModel() {
        running=true;
        options = new ArrayList<>();
        for(MenuOption temp: MenuOption.values()){
            options.add(new MenuElement(temp));
        }
        this.selected = 0;
        options.get(selected).setFillColor(new TextColor.RGB(255, 202, 24));
        options.get(selected).setBorderColor(new TextColor.RGB(255, 202, 24));
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

    public MenuElement<MenuOption> getSelectedElement(){return  options.get(selected);}

    public List<MenuElement<MenuOption>> getOptions(){return options;}

    @Override
    public void setRunning(boolean running){this.running=running;}

    @Override
    public boolean isRunning(){return running;}
}
