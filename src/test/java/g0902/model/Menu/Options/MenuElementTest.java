package g0902.model.Menu.Options;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuElementTest {
    private MenuElement element;

    @BeforeEach
    public void setup(){
        element=new MenuElement("START");
        element.select();
    }
    @Test
    public void isSelected(){
        Assertions.assertEquals(true, element.isSelected());
        element.deselect();
        Assertions.assertEquals(false, element.isSelected());
    }
    @Test
    public void select(){
        Assertions.assertEquals(true, element.isSelected());
    }
    @Test
    public void deselect(){
        Assertions.assertEquals(true, element.isSelected());
        element.deselect();
        Assertions.assertEquals(false, element.isSelected());
    }
}
