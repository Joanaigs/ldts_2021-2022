package model.Elements;

import model.Maps.Builders.MapBuilder;
import model.Maps.Builders.MapReader;
import model.Maps.Map;
import model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GhostsTest extends Assertions {

    // The following 4 tests, test if each ghost is being read correctly
    @Test
    void readRedTest() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        Map map = mapbuilder.createMap("mapTest4");
        // using a diferent map then the one used in the game, so is easier to test
        assertEquals(map.getRed().getPosition(), new Position(2 * 8 + 1, 12 * 12 - 1));
    }

    @Test
    void readPinkTest() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        Map map = mapbuilder.createMap("mapTest4");
        // using a diferent map then the one used in the game, so is easier to test
        assertEquals(map.getPink().getPosition(), new Position(2 * 8 + 1, 14 * 12 - 1));
    }

    @Test
    void readOrangeTest() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        Map map = mapbuilder.createMap("mapTest4");
        // using a diferent map then the one used in the game, so is easier to test
        assertEquals(map.getOrange().getPosition(), new Position(2 * 8 + 1, 16 * 12 - 1));
    }

    @Test
    void readCyanTest() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        Map map = mapbuilder.createMap("mapTest4");
        // using a diferent map then the one used in the game, so is easier to test
        assertEquals(map.getCyan().getPosition(), new Position(2 * 8 + 1, 30 * 12 - 1));
    }
}
