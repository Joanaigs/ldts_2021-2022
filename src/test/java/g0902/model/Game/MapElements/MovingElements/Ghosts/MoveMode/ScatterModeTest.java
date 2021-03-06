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

public class ScatterModeTest {

    MapBuilder mapbuilder;
    Map map;

    @BeforeEach
    public void helper() throws IOException {
            mapbuilder = new MapReader();
            map = mapbuilder.createMap("map");
    }

    @Test
    void cyanScatter(){
        Cyan cyan=new Cyan(map.getCyan().getPosition());
        cyan.setMap(map);
        cyan.setCurrentDirection(cyan.getScatterBehaviour().Scatter(20));
        Assertions.assertEquals(Direction.Right, cyan.getCurrentDirection());
    }

    @Test
    void orangeScatter(){
        Orange orange=new Orange(map.getOrange().getPosition());
        orange.setMap(map);
        orange.setCurrentDirection(orange.getScatterBehaviour().Scatter(20));
        Assertions.assertEquals(Direction.Left, orange.getCurrentDirection());
    }

    @Test
    void pinkScatter(){
        Pink pink=new Pink(map.getPink().getPosition());
        pink.setMap(map);
        pink.setCurrentDirection(pink.getScatterBehaviour().Scatter(20));
        Assertions.assertEquals(Direction.Left, pink.getCurrentDirection());
    }
    @Test
    void redScatter(){
        Red red=new Red(map.getRed().getPosition());
        red.setMap(map);
        red.setCurrentDirection(red.getScatterBehaviour().Scatter(20));
        Assertions.assertEquals(Direction.Right, red.getCurrentDirection());
    }
}
