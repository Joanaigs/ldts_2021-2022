package g0902;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConfigurationTest extends Assertions {
    Configuration configuration = Configuration.getInstance();

    @Test
    void nextLevel(){
        assertEquals(9000,configuration.getFrightenedTime());
        assertEquals(20000,configuration.getChaseTime());
        configuration.nextLevel();
        assertEquals(7000,configuration.getFrightenedTime());
        assertEquals(22000,configuration.getChaseTime());
        configuration.nextLevel();
        assertEquals(5000,configuration.getFrightenedTime());
        assertEquals(24000,configuration.getChaseTime());
        configuration.nextLevel();
        assertEquals(3000,configuration.getFrightenedTime());
        assertEquals(26000,configuration.getChaseTime());
        configuration.nextLevel();
        assertEquals(1000,configuration.getFrightenedTime());
        assertEquals(28000,configuration.getChaseTime());
        configuration.nextLevel();
        assertEquals(1000,configuration.getFrightenedTime());
        assertEquals(30000,configuration.getChaseTime());
    }


}
