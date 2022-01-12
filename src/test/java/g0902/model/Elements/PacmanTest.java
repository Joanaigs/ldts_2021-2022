package g0902.model.Elements;

import g0902.model.Elements.Coins.PowerCoin;
import g0902.model.Elements.Coins.SmallCoin;
import g0902.model.Maps.Builders.MapBuilder;
import g0902.model.Maps.Builders.MapReader;
import g0902.model.Maps.Map;
import g0902.model.Position;
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

    @Test
    void moveTest(){
        Assertions.assertEquals(new Position(3*8+1-(50*20/1000), 3*12-1), pacman.move(20, Direction.Up));
        Assertions.assertEquals(new Position(3*8+1+(50*20/1000), 3*12-1), pacman.move(20, Direction.Down));
        Assertions.assertEquals(new Position(3*8+1, (int)3*12-3), pacman.move(20, Direction.Left));
        Assertions.assertEquals(new Position(3*8+1, (int)3*12+1), pacman.move(20, Direction.Right));
        Assertions.assertEquals(new Position(3*8+1, 3*12-1), pacman.move(20, Direction.None));

        pacman.setDirection(Direction.Up);
        Assertions.assertEquals(new Position(3*8+1-(50*20/1000), 3*12-1), pacman.moveNextDirection(20));
        pacman.nextDirection();
        Assertions.assertEquals(new Position(3*8+1-(50*20/1000), 3*12-1), pacman.moveCurrentDirection(20));
        Assertions.assertEquals(new Position(3*8+1, 3*12-1), pacman.getBeginPosition());
        Assertions.assertEquals(true, pacman.isOpen());
        pacman.setMouthOpen(false);
        Assertions.assertEquals(false, pacman.isOpen());
        pacman.setDirection(Direction.Down);
        Assertions.assertEquals(Direction.Down, pacman.getNextDirection());
        pacman.setPosition(new Position(1,1));
        Assertions.assertEquals(new Position(1,1), pacman.getPosition());
    }
}
