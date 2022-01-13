package g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.TargetStrategies;

import g0902.model.Direction;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseMode.TargetStrategys.PatrolTargetStrategy;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import g0902.model.Game.Map.Builders.MapReader;
import g0902.model.Game.Map.Map;
import g0902.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class PatrolTargetStrategyTest {
    @Test
    void getTarget() throws IOException {
        Position position=mock(Position.class);
        PatrolTargetStrategy a=new PatrolTargetStrategy();
        MapReader mapReader=new MapReader();
        Map map=mapReader.createMap("mapTest");

        Assertions.assertEquals(new Position(39, 0), a.getTarget(position, map));

        Pacman pacman=map.getPacman();
        pacman.setCurrentDirection(Direction.Up);
        Assertions.assertEquals(new Position(-25, 48), a.getTarget(position, map));

        pacman.setCurrentDirection(Direction.Left);
        map.setPacman(pacman);
        Assertions.assertEquals(new Position(7, -48), a.getTarget(position, map));

        pacman.setCurrentDirection(Direction.Right);
        map.setPacman(pacman);
        Assertions.assertEquals(new Position(7, 48), a.getTarget(position, map));

        pacman.setCurrentDirection(Direction.None);
        map.setPacman(pacman);
        Assertions.assertEquals(new Position(-25, 48), a.getTarget(position, map));
    }
}
