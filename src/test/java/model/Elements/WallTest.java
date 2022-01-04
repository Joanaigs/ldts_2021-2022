package model.Elements;

import model.Elements.Wall;
import model.Maps.Builders.MapBuilder;
import model.Maps.Builders.MapReader;
import model.Maps.Map;
import model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class WallTest extends Assertions{

    @Test
    void readWallTest() throws IOException{

        MapBuilder mapbuilder = new MapReader();
        Map map = mapbuilder.createMap("mapTest"); // here we are using a 3x3 map to test if the functions are working.


        //To see if it's reading the right number of power coins
        assertEquals(20, map.getWalls().size());

        // List of each power coin position on the map "mapTest"
        ArrayList<Wall> wallList = new ArrayList<>(
                Arrays.asList(  new Wall(new Position(0*8,0*12), 12, 8),
                        new Wall(new Position(0*8,1*12), 12, 8),
                        new Wall(new Position(0*8,2*12), 12, 8),
                        new Wall(new Position(0*8,3*12), 12, 8),
                        new Wall(new Position(0*8,4*12), 12, 8),
                        new Wall(new Position(0*8,5*12), 12, 8),
                        new Wall(new Position(0*8,6*12), 12, 8),
                        new Wall(new Position(0*8,7*12), 12, 8),
                        new Wall(new Position(0*8,8*12), 12, 8),
                        new Wall(new Position(1*8,0*12), 12, 8),
                        new Wall(new Position(1*8,8*12), 12, 8),
                        new Wall( new Position(0*8,0*12), 12, 8),
                        new Wall(new Position(2*8,0*12), 12, 8),
                        new Wall(new Position(2*8,1*12), 12, 8),
                        new Wall(new Position(2*8,2*12), 12, 8),
                        new Wall(new Position(2*8,3*12), 12, 8),
                        new Wall(new Position(2*8,4*12), 12, 8),
                        new Wall(new Position(2*8,5*12), 12, 8),
                        new Wall(new Position(2*8,6*12), 12, 8),
                        new Wall(new Position(2*8,7*12), 12, 8),
                        new Wall(new Position(2*8,8*12), 12, 8)));

        //To see if it's reading the correct walls
        assertEquals(true, wallList.containsAll(map.getWalls()));
        assertEquals(true, map.getWalls().containsAll(wallList));

    }


}
