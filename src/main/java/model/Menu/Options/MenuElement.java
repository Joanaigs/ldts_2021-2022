package model.Menu.Options;
import com.googlecode.lanterna.TextColor;

public class MenuElement {
    private String id;
    private boolean selected;
    private TextColor fillColor;
    private TextColor borderColor;

    public MenuElement(String id, TextColor fillColor, TextColor borderColor){
        this.id = id;
        this.selected = false;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public String getIdentifier() {
        return id;
    }

    public boolean isSelected(){
        return this.selected;
    }

    public void select(){
        this.selected = true;
    }

    public void deselect(){
        this.selected = false;
    }

    public TextColor getFillColor() {
        return fillColor;
    }

    public TextColor getBorderColor() {
        return borderColor;
    }
}

