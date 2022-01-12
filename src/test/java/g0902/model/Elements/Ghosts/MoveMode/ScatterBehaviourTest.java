package g0902.model.Elements.Ghosts.MoveMode;

import g0902.model.Direction;
import g0902.model.Elements.Ghosts.MoveMode.ScatterMode.ScatterBehaviour;
import g0902.model.Elements.Ghosts.Types.Red;
import g0902.model.Maps.Builders.MapBuilder;
import g0902.model.Maps.Builders.MapReader;
import g0902.model.Maps.Map;
import g0902.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class ScatterBehaviourTest {
    @Test
    void Scatter() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        Map map = mapbuilder.createMap("map");
        Red red=new Red(map.getCyan().getPosition());
        ScatterBehaviour scatterBehaviour=new ScatterBehaviour(red, List.of(new Position(35*8, 12),
                new Position(38*8, 12),
                new Position(38*8, 17*12),
                new Position(35*8, 17*12)));
        scatterBehaviour.setMap(map);
        Assertions.assertEquals(Direction.Left, scatterBehaviour.Scatter(20));
    }
}
