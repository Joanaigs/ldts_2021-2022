package model.Elements.Ghosts.MoveMode;

import model.Elements.Direction;
import model.Elements.Ghosts.Types.Cyan;
import model.Elements.Ghosts.Types.Orange;
import model.Elements.Ghosts.Types.Pink;
import model.Elements.Ghosts.Types.Red;
import model.Maps.Builders.MapBuilder;
import model.Maps.Builders.MapReader;
import model.Maps.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ChaseModeTest {

    @Test
    void Chase() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        Map map = mapbuilder.createMap("map");

        Cyan cyan=new Cyan(map.getCyan().getPosition());
        cyan.setMap(map);
        cyan.update(20);
        Assertions.assertEquals(Direction.Down, cyan.getCurrentDirection());

        Orange orange=new Orange(map.getOrange().getPosition());
        orange.setMap(map);
        orange.update(20);
        Assertions.assertEquals(Direction.Down, orange.getCurrentDirection());

        Pink pink=new Pink(map.getCyan().getPosition());
        pink.setMap(map);
        pink.update(20);
        Assertions.assertEquals(Direction.Down, pink.getCurrentDirection());

        Red red=new Red(map.getCyan().getPosition());
        red.setMap(map);
        red.update(20);
        Assertions.assertEquals(Direction.Down, red.getCurrentDirection());
        return;
    }


}
