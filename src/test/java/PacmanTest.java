package Elements;

import model.Elements.Direction;
import model.Elements.Pacman;
import model.Maps.Builders.MapBuilder;
import model.Maps.Builders.MapReader;
import model.Maps.Map;
import model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacmanTest {

    private Pacman pacman;

    @BeforeEach
    public void createPacman(){
        pacman = new Pacman(new Position(3*8+1, 3*12-1));
    }

    //Tests if the pacman is being correctly readed from the map.
    @Test
    void readPacmanTest() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        Map map = mapbuilder.createMap("mapTest"); // here we are using a 3x3 map to test if the functions are working.
        assertEquals(map.getPacman().getPosition(), new Position(1*8+1,1*12-1));
    }

    // On the following 4 testes, is being tested if pacman changes direction correctly.
    @Test
    void moveUp() {
        assertEquals(Direction.Up, pacman.moveUp());
    }

    @Test
    void moveDown(){
        assertEquals(Direction.Down, pacman.moveDown());
    }
    @Test
    void moveLeft(){
        assertEquals(Direction.Left, pacman.moveLeft());
    }

    @Test
    void moveRight(){
        assertEquals(Direction.Right, pacman.moveRight());
    }

    // Tests if the position is being changed correctly
    @Test
    void changePosition(){
        long deltatime = -8/62/3;
        double velocity = 62/3;
        Position pos1 = pacman.move(deltatime, Direction.Up);
        Position pos2 = new Position((3*8+1)-(int)(velocity*deltatime/1000), 3*12-1);
        Assertions.assertTrue(pos1.equals(pos2));
    }



}
