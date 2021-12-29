package model.Menu.Options;
import com.googlecode.lanterna.TextColor;

public class MenuElement<T> {
    private T id;
    private boolean selected;
    private TextColor fillColor;
    private TextColor borderColor;

    public MenuElement(T id){
        this.id = id;
        this.selected = false;
        this.fillColor = new TextColor.RGB(255, 255, 255);
        this.borderColor = new TextColor.RGB(255, 255, 255);
    }

    public String getIdentifier() {
        return id.toString();
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

    public void setFillColor(TextColor fillColor) {
        this.fillColor = fillColor;
    }

    public void setBorderColor(TextColor borderColor) {
        this.borderColor = borderColor;
    }
}

