package model.Elements;

import model.Elements.Ghosts.Ghost;
import model.Maps.Builders.MapBuilder;
import model.Maps.Builders.MapReader;
import model.Maps.Map;
import model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GhostsTest extends Assertions {
    Ghost ghost;

    @BeforeEach
    public void createPacman(){
        ghost = new Ghost(new Position(3*8+1, 3*12-1));
    }

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

    @Test
    void changePositionTest(){
        long deltatime = -8/62/3;
        double velocity = 62/3;
        Position pos1 = ghost.move(deltatime, Direction.Up);
        Position pos2 = new Position((3*8+1)-(int)(velocity*deltatime/1000), 3*12-1);
        Assertions.assertTrue(pos1.equals(pos2));
    }

}
