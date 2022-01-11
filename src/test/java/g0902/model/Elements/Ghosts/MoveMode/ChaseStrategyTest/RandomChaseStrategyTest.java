package g0902.model.Elements.Ghosts.MoveMode.ChaseStrategyTest;

import g0902.model.Elements.Direction;
import g0902.model.Elements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.RandomChaseStrategy;
import g0902.model.Elements.Ghosts.MoveMode.ChaseMode.TargetStrategys.AggressiveTargetStrategy;
import g0902.model.Elements.Ghosts.Types.Cyan;
import g0902.model.Maps.Builders.MapReader;
import g0902.model.Maps.Map;
import g0902.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class RandomChaseStrategyTest {
    @Test
    void chaseTest() throws IOException {
        MapReader mapReader=new MapReader();
        Map map=mapReader.createMap("map");
        Position position=mock(Position.class);
        Cyan cyan=new Cyan(position);
        RandomChaseStrategy a=new RandomChaseStrategy(cyan);
        a.setMap(map);
        Assertions.assertEquals(Direction.None,  a.chase(20));
    }
}
