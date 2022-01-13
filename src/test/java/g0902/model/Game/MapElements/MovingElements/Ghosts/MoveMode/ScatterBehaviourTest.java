package g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode;

import g0902.model.Direction;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ScatterMode.ScatterBehaviour;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Red;
import g0902.model.Game.Map.Builders.MapBuilder;
import g0902.model.Game.Map.Builders.MapReader;
import g0902.model.Game.Map.Map;
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
        Red red=new Red(map.getRed().getPosition());
        ScatterBehaviour scatterBehaviour=new ScatterBehaviour(red, List.of(new Position(35*8, 12),
                new Position(38*8, 12),
                new Position(38*8, 17*12),
                new Position(35*8, 17*12)));
        red.setMap(map);
        Assertions.assertEquals(Direction.Left, scatterBehaviour.Scatter(20));
    }
}
