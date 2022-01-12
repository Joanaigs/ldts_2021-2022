package g0902.model.Elements;

import g0902.model.Maps.Builders.MapBuilder;
import g0902.model.Maps.Builders.MapReader;
import g0902.model.Maps.Map;
import g0902.model.Position;
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
        assertEquals(true, wallList.get(0).equals(wallList.get(0)));
        assertEquals(false, wallList.get(0).equals(wallList.get(1)));
        assertEquals(false, wallList.get(0).equals(null));
        assertEquals(12, wallList.get(0).getWidth());
        assertEquals(8, wallList.get(0).getHeight());

        //testing position
        assertEquals(true, wallList.get(0).getPosition().equals(new Position(0*8,0*12)));
        assertEquals(false, wallList.get(0).getPosition().equals(new Position(0*8,1*12)));
        assertEquals(false, wallList.get(0).getPosition().equals(null));
        assertEquals(961, wallList.get(0).getPosition().hashCode());

    }


}
