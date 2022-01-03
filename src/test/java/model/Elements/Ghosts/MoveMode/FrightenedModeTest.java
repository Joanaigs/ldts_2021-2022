package model.Elements.Ghosts.Moves;

import model.Elements.Direction;
import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Moves.FrightenedMode.FrightenedMode;
import model.Elements.Ghosts.Types.Cyan;
import model.Elements.Ghosts.Types.Orange;
import model.Elements.Ghosts.Types.Pink;
import model.Elements.Ghosts.Types.Red;
import model.Maps.Builders.MapBuilder;
import model.Maps.Builders.MapReader;
import model.Maps.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.ElementsView.Ghosts.FrightenedView;

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
    void FrightenedTest() throws IOException {
        cyan.update(20);
        cyan.setFrightenedModeOn();
        cyan.update(20);
        Assertions.assertEquals(Direction.Up, cyan.getCurrentDirection()); //they turn 180 degrees

        orange.update(20);
        orange.setFrightenedModeOn();
        orange.update(20);
        Assertions.assertEquals(Direction.Up, orange.getCurrentDirection()); //they turn 180 degrees

        pink.update(20);
        pink.setFrightenedModeOn();
        pink.update(20);
        Assertions.assertEquals(Direction.Up, pink.getCurrentDirection()); //they turn 180 degrees

        red.update(20);
        red.setFrightenedModeOn();
        red.update(20);
        Assertions.assertEquals(Direction.Up, red.getCurrentDirection()); //they turn 180 degrees
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
