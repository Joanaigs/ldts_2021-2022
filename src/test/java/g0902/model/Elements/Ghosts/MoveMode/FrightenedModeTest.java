package g0902.model.Elements.Ghosts.MoveMode;

import g0902.model.Direction;
import g0902.model.Elements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import g0902.model.Elements.Ghosts.Types.Cyan;
import g0902.model.Elements.Ghosts.Types.Orange;
import g0902.model.Elements.Ghosts.Types.Pink;
import g0902.model.Elements.Ghosts.Types.Red;
import g0902.model.Maps.Builders.MapBuilder;
import g0902.model.Maps.Builders.MapReader;
import g0902.model.Maps.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FrightenedModeTest {
    private Red red;
    private Pink pink;
    private Cyan cyan;
    private Orange orange;

    @BeforeEach
    void setup() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        Map map = mapbuilder.createMap("map");
        this.red=new Red(map.getCyan().getPosition());
        red.setMap(map);
        this.pink=new Pink(map.getCyan().getPosition());
        pink.setMap(map);
        this.orange=new Orange(map.getOrange().getPosition());
        orange.setMap(map);
        this.cyan=new Cyan(map.getCyan().getPosition());
        cyan.setMap(map);
    }

    @Test
    void cyanMove(){
        cyan.update(20);
        cyan.setFrightenedModeOn();
        cyan.update(20);
        Assertions.assertEquals(Direction.Left, cyan.getCurrentDirection()); //they turn 180 degrees

    }

    @Test
    void orangeMove(){
        orange.update(20);
        orange.setFrightenedModeOn();
        orange.update(20);
        Assertions.assertEquals(Direction.Right, orange.getCurrentDirection()); //they turn 180 degrees

    }

    @Test
    void pinkMove(){
        pink.update(20);
        pink.setFrightenedModeOn();
        pink.update(20);
        Assertions.assertEquals(Direction.Right, pink.getCurrentDirection()); //they turn 180 degrees

    }
    @Test
    void redMove(){
        red.update(20);
        red.setFrightenedModeOn();
        red.update(20);
        Assertions.assertEquals(Direction.Left, red.getCurrentDirection());
    }

    @Test
    void getRandomNumberTest(){
        FrightenedMode frightenedMode = new FrightenedMode(red);
        int min = 4;
        int max = 9;
        int randNum = frightenedMode.getRandomNumberInRange(4, 9);
        Assertions.assertTrue(randNum>=4 && randNum<=9);
    }
}
