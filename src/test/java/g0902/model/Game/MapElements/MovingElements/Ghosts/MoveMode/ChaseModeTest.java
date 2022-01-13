package g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode;

import g0902.model.Direction;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Cyan;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Orange;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Pink;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Red;
import g0902.model.Game.Map.Builders.MapBuilder;
import g0902.model.Game.Map.Builders.MapReader;
import g0902.model.Game.Map.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ChaseModeTest {
    MapBuilder mapbuilder;
    Map map;

    @BeforeEach
    void setup() throws IOException {
        mapbuilder = new MapReader();
        map = mapbuilder.createMap("map");
    }

    @Test
    void cyanChase(){
        Cyan cyan=new Cyan(map.getCyan().getPosition());
        cyan.setMap(map);
        cyan.update(20);
        Assertions.assertEquals(Direction.Right, cyan.getCurrentDirection());

    }

    @Test
    void orangeChase(){
        Orange orange=new Orange(map.getOrange().getPosition());
        orange.setMap(map);
        orange.update(20);
        Assertions.assertEquals(Direction.Left, orange.getCurrentDirection());

    }

    @Test
    void pinkChase(){
        Pink pink=new Pink(map.getCyan().getPosition());
        pink.setMap(map);
        pink.update(20);
        Assertions.assertEquals(Direction.Left, pink.getCurrentDirection());

    }
    @Test
    void redChase(){
        Red red=new Red(map.getCyan().getPosition());
        red.setMap(map);
        red.update(20);
        Assertions.assertEquals(Direction.Right, red.getCurrentDirection());
    }

}
