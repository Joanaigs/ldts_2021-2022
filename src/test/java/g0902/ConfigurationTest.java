package g0902;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConfigurationTest extends Assertions {
    Configuration configuration;

    @BeforeEach
    public void setup(){
        Configuration.clearConfiguration();
        configuration = Configuration.getInstance();
    }

    @Test
    void nextLevel(){

        // First level
        assertEquals(9000,configuration.getFrightenedTime());
        assertEquals(20000,configuration.getChaseTime());
        configuration.nextLevel();

        // Next level
        assertEquals(7000,configuration.getFrightenedTime());
        assertEquals(22000,configuration.getChaseTime());
        configuration.nextLevel();

        // Next level...
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

    @Test
    public void musicGetters(){
        Assertions.assertNotNull(configuration.getMenuMusic());
        Assertions.assertNotNull(configuration.getFrightenedModeMusic());
        Assertions.assertNotNull(configuration.getEndScreenMusic());
        Assertions.assertNotNull(configuration.getNormalModeMusic());
    }

}
