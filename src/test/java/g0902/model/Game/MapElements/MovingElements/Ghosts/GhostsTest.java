package g0902.model.Game.MapElements.MovingElements.Ghosts;

import g0902.model.Game.Map.Builders.MapBuilder;
import g0902.model.Game.Map.Builders.MapReader;
import g0902.model.Game.Map.Map;
import g0902.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GhostsTest extends Assertions {
    Map map;

    @BeforeEach
    public void createMap() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        map = mapbuilder.createMap("mapTest");
        // using a diferent map then the one used in the game, so is easier to test
    }

    // The following 4 tests, test if each ghost is being read correctly
    @Test
    void readRedTest() throws IOException {
        assertEquals(map.getRed().getPosition(), new Position(1 * 8+1, 2 * 12));
    }

    @Test
    void readPinkTest() throws IOException {
        assertEquals(map.getPink().getPosition(), new Position(1 * 8+1, 3 * 12));
    }

    @Test
    void readOrangeTest() throws IOException {
        assertEquals(map.getOrange().getPosition(), new Position(1 * 8+1, 4 * 12));
    }

    @Test
    void readCyanTest() throws IOException {
        assertEquals(map.getCyan().getPosition(), new Position(1 * 8+1, 5 * 12));
    }

}
