package g0902.model.Elements.Ghosts.MoveMode;

import g0902.model.Elements.Direction;
import g0902.model.Elements.Ghosts.Ghost;
import g0902.model.Elements.Ghosts.MoveMode.ScatterMode.ScatterBehaviour;
import g0902.model.Elements.Ghosts.Types.Red;
import g0902.model.Maps.Builders.MapBuilder;
import g0902.model.Maps.Builders.MapReader;
import g0902.model.Maps.Map;
import g0902.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.mock;

public class ScatterBehaviourTest {
    MapBuilder mapBuilder;
    Map map;
    Red red;

    @Test
    void Scatter() throws IOException {
        mapBuilder = new MapReader();
        map = mapBuilder.createMap("map");
        red = new Red(map.getRed().getPosition());
        ScatterBehaviour scatterBehaviour = new ScatterBehaviour(red, List.of(new Position(35 * 8, 12),
                new Position(38 * 8, 12),
                new Position(38 * 8, 17 * 12),
                new Position(35 * 8, 17 * 12)));
        scatterBehaviour.setMap(map);
        Assertions.assertEquals(Direction.Left, scatterBehaviour.Scatter(20));
    }

    @Test
    void findGoToPosition() {
        red = mock(Red.class);
        ScatterBehaviour scatterBehaviour = new ScatterBehaviour(red, List.of(new Position(35 * 8, 12),
                new Position(38 * 8, 12),
                new Position(38 * 8, 17 * 12),
                new Position(35 * 8, 17 * 12)));
        scatterBehaviour.setMap(mock(Map.class));
        scatterBehaviour.findToGoPosition();
        Mockito.verify(red, Mockito.times(4)).getPosition();
    }
}