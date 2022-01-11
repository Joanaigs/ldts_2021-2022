package g0902.model.Menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EndScreenModelTest {

    @Test
    void test(){
        EndScreenModel endScreenModel=new EndScreenModel();
        Assertions.assertEquals("___", endScreenModel.name);
        Assertions.assertEquals(false, endScreenModel.lost);
        Assertions.assertEquals(true, endScreenModel.isRunning());
        endScreenModel.addLetter('s');
        Assertions.assertEquals("s__", endScreenModel.name);
    }
}
