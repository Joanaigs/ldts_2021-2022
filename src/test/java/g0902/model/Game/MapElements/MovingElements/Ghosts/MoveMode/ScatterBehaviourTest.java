package g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode;


import g0902.model.Direction;
import g0902.model.Game.Map.Builders.MapBuilder;
import g0902.model.Game.Map.Builders.MapReader;
import g0902.model.Game.Map.Map;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ScatterMode.ScatterBehaviour;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Red;
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
    ScatterBehaviour scatterBehaviour;

    @BeforeEach
    void setUp() throws IOException {
        mapBuilder = new MapReader();
        map = mapBuilder.createMap("map");
    }

    @Test
    void Scatter() {
        Red red=new Red(map.getRed().getPosition());
        red.setMap(map);
        scatterBehaviour = new ScatterBehaviour(red, List.of(new Position(13 * 8, 14),
                new Position(38 * 8, 12),
                new Position(38 * 8, 17 * 12),
                new Position(35 * 8, 17 * 12)));
        //scatterBehaviour.setMap(map);
        Assertions.assertEquals(Direction.Left, scatterBehaviour.Scatter(20));
        Assertions.assertEquals(new Position(104, 14), scatterBehaviour.getToGoPosition());
    }

    @Test
    void findGoToPosition() {
        red = mock(Red.class);
        scatterBehaviour = new ScatterBehaviour(red, List.of(new Position(13 * 8, 14),
                new Position(38 * 8, 12),
                new Position(38 * 8, 17 * 12),
                new Position(35 * 8, 17 * 12)));
        //scatterBehaviour.setMap(map);

        Mockito.when(red.getPosition()).thenReturn(new Position(13 * 8, 14));
        scatterBehaviour.findToGoPosition();
        Assertions.assertEquals(new Position(38 * 8, 12), scatterBehaviour.getToGoPosition());

        Mockito.when(red.getPosition()).thenReturn(new Position(38 * 8, 12));
        scatterBehaviour.findToGoPosition();
        Assertions.assertEquals(new Position(38 * 8, 17 * 12), scatterBehaviour.getToGoPosition());

        Mockito.when(red.getPosition()).thenReturn(new Position(38 * 8, 17 * 12));
        scatterBehaviour.findToGoPosition();
        Assertions.assertEquals(new Position(35 * 8, 17 * 12), scatterBehaviour.getToGoPosition());

        Mockito.when(red.getPosition()).thenReturn(new Position(35 * 8, 17 * 12));
        scatterBehaviour.findToGoPosition();
        Assertions.assertEquals(new Position(13 * 8, 14), scatterBehaviour.getToGoPosition());

        Mockito.verify(red, Mockito.times(10)).getPosition();
    }
}