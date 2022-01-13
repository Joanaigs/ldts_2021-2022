package g0902.model.Menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EndScreenModelTest {

    @Test
    void test(){
        EndScreenModel endScreenModel=new EndScreenModel();
        Assertions.assertEquals("___", endScreenModel.getName());
        Assertions.assertEquals(false, endScreenModel.hasLost());
        Assertions.assertEquals(true, endScreenModel.isRunning());
        endScreenModel.setLost(true);
        Assertions.assertTrue(endScreenModel.hasLost());
        endScreenModel.setRunning(false);
        Assertions.assertFalse(endScreenModel.isRunning());
        endScreenModel.addLetter('s');
        Assertions.assertEquals("s__", endScreenModel.getName());
        endScreenModel.setScore(200);
        Assertions.assertEquals(200, endScreenModel.getScore());
    }
}
