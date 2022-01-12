package g0902.model.Game.MapElements;

import g0902.model.Direction;
import g0902.model.Game.MapElements.Coins.PowerCoin;
import g0902.model.Game.MapElements.Coins.SmallCoin;
import g0902.model.Game.Map.Builders.MapBuilder;
import g0902.model.Game.Map.Builders.MapReader;
import g0902.model.Game.Map.Map;
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
        assertEquals(map.getPacman().getPosition(), new Position(8,12));
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
