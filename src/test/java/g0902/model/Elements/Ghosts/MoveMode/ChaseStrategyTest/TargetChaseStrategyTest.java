package g0902.model.Elements.Ghosts.MoveMode.ChaseStrategyTest;

import g0902.model.Direction;
import g0902.model.Elements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.TargetChaseStrategy;
import g0902.model.Elements.Ghosts.MoveMode.ChaseMode.TargetStrategys.AggressiveTargetStrategy;
import g0902.model.Elements.Ghosts.Types.Cyan;
import g0902.model.Maps.Builders.MapReader;
import g0902.model.Maps.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class TargetChaseStrategyTest {
    @Test
    void chaseTest() throws IOException {
        MapReader mapReader=new MapReader();
        Map map=mapReader.createMap("map");
        Cyan cyan= (Cyan) map.getCyan();
        cyan.setCurrentDirection(Direction.Right);
        TargetChaseStrategy a=new TargetChaseStrategy(new AggressiveTargetStrategy(), cyan);
        a.setMap(map);
        Assertions.assertEquals(Direction.Right,  a.chase(20));
    }
}
