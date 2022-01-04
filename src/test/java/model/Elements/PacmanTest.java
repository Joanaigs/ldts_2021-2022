package model.Elements;

import model.Elements.Coins.PowerCoin;
import model.Elements.Coins.SmallCoin;
import model.Maps.Builders.MapBuilder;
import model.Maps.Builders.MapReader;
import model.Maps.Map;
import model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PacmanTest extends Assertions{

    private Pacman pacman;

    @BeforeEach
    public void createPacman(){
        pacman = new Pacman(new Position(3*8+1, 3*12-1));
    }

    @Test
    //Tests if the pacman is being correctly read from the map.
    void readPacmanTest() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        Map map = mapbuilder.createMap("mapTest2"); // here we are using a 3x3 map to test if the functions are working.
        assertEquals(map.getPacman().getPosition(), new Position(1*8,1*12));
    }

    @Test
    // On the following 4 tests, is being tested if pacman changes direction correctly.
    void moveUpTest() {
        assertEquals(Direction.Up, pacman.moveUp());
    }

    @Test
    void moveDownTest(){
        assertEquals(Direction.Down, pacman.moveDown());
    }
    @Test
    void moveLeftTest(){
        assertEquals(Direction.Left, pacman.moveLeft());
    }

    @Test
    void moveRightTest(){
        assertEquals(Direction.Right, pacman.moveRight());
    }

    @Test
    // Tests if the position is being changed correctly
    void changePositionTest(){
        long deltatime = -8/62/3;
        double velocity = 62/3;
        Position pos1 = pacman.move(deltatime, Direction.Up);
        Position pos2 = new Position((3*8+1)-(int)(velocity*deltatime/1000), 3*12-1);
        Assertions.assertTrue(pos1.equals(pos2));
    }


    @Test
        // Tests if the score is being updated correctly
    void increaseScoreTest(){
        pacman.increaseScore(PowerCoin.PowerCoinValue);
        assertEquals(200, pacman.getScore());
        pacman.increaseScore(SmallCoin.SmallCoinValue);
        assertEquals(210, pacman.getScore());
    }
}
