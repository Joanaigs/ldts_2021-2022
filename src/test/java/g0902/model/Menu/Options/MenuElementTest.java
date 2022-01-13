package g0902.model.Menu.Options;

import g0902.model.Menu.MainMenuModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

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
