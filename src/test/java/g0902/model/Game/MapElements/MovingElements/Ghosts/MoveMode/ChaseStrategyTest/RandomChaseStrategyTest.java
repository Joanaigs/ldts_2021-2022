package g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseStrategyTest;


import g0902.model.Direction;
import g0902.model.Game.Map.Builders.MapReader;
import g0902.model.Game.Map.Map;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.RandomChaseStrategy;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Pink;
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
        Pink pink=new Pink(position);
        pink.setCurrentDirection(Direction.Left);
        RandomChaseStrategy a=new RandomChaseStrategy(pink);
        Assertions.assertEquals(Direction.Left,  a.chase(20));
        Assertions.assertThrows(IllegalArgumentException.class, ()->{a.getRandomNumberInRange(10, 5);}, "max must be greater than min");

    }
}
