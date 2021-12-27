package model.Menu.Options;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuElementTest {
    @Test
    public void isSelected(){
        MenuElement element=new MenuElement("START", new TextColor.RGB(255, 255, 255), new TextColor.RGB(255, 255, 255));
        element.select();
        Assertions.assertEquals(true, element.isSelected());
        element.deselect();
        Assertions.assertEquals(false, element.isSelected());
    }
    @Test
    public void select(){
        MenuElement element=new MenuElement("START", new TextColor.RGB(255, 255, 255), new TextColor.RGB(255, 255, 255));
        element.select();
        Assertions.assertEquals(true, element.isSelected());
    }
    @Test
    public void deselect(){
        MenuElement element=new MenuElement("START", new TextColor.RGB(255, 255, 255), new TextColor.RGB(255, 255, 255));
        element.select();
        Assertions.assertEquals(true, element.isSelected());
        element.deselect();
        Assertions.assertEquals(false, element.isSelected());
    }
}
