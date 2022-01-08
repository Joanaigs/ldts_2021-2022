package g0902.model.Elements.Ghosts.MoveMode.TargetStrategies;

import g0902.model.Elements.Ghosts.MoveMode.ChaseMode.TargetStrategys.AggressiveTargetStrategy;
import g0902.model.Maps.Builders.MapReader;
import g0902.model.Maps.Map;
import g0902.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class AggressiveTargetStrategyTest {
    @Test
    void getTarget() throws IOException {
        Position position=mock(Position.class);
        AggressiveTargetStrategy a=new AggressiveTargetStrategy();
        MapReader mapReader=new MapReader();
        Assertions.assertEquals(new Position(1*8, 1*12),  a.getTarget(position, mapReader.createMap("mapTest")));
    }
}
