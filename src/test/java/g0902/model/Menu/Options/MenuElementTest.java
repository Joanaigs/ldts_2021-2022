package g0902.model.Menu.Options;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuElementTest {
    @Test
    public void isSelected(){
        MenuElement element=new MenuElement("START");
        element.select();
        Assertions.assertEquals(true, element.isSelected());
        element.deselect();
        Assertions.assertEquals(false, element.isSelected());
    }
    @Test
    public void select(){
        MenuElement element=new MenuElement("START");
        element.select();
        Assertions.assertEquals(true, element.isSelected());
    }
    @Test
    public void deselect(){
        MenuElement element=new MenuElement("START");
        element.select();
        Assertions.assertEquals(true, element.isSelected());
        element.deselect();
        Assertions.assertEquals(false, element.isSelected());
    }
}
