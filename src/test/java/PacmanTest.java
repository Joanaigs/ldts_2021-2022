import model.Elements.Direction;
import model.Elements.Pacman;
import model.Maps.Builders.MapBuilder;
import model.Maps.Builders.MapReader;
import model.Maps.Map;
import model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacmanTest {

    @Test
    //Tests if the pacman is being correctly readed from the map.
    void readPacmanTest() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        Map map = mapbuilder.createMap("mapTest"); // here we are using a 3x3 map to test if the functions are working.
        assertEquals(map.getPacman().getPosition(), new Position(1*8+1,1*12-1));
    }

    // Tests if it changes direction to up correctly.
    @Test
    void moveUp() {
        Pacman pacman = new Pacman(new Position(3, 3));
        assertEquals(Direction.Up, pacman.moveUp());
    }

    @Test
    void moveDown(){
        Pacman pacman = new Pacman(new Position(3, 3));
        assertEquals(Direction.Down, pacman.moveDown());
    }
    @Test
    void moveLeft(){
        Pacman pacman = new Pacman(new Position(3, 3));
        assertEquals(Direction.Left, pacman.moveLeft());
    }

    @Test
    void moveRight(){
        Pacman pacman = new Pacman(new Position(3, 3));
        assertEquals(Direction.Right, pacman.moveRight());
    }

    @Test
    void changePosition(){

    }

}
