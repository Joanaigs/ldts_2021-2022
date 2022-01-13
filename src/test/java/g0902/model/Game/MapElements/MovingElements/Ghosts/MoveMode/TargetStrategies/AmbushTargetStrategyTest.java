package g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.TargetStrategies;

import g0902.model.Direction;
import g0902.model.Game.Map.Builders.MapReader;
import g0902.model.Game.Map.Map;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseMode.TargetStrategys.AmbushTargetStrategy;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import g0902.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class AmbushTargetStrategyTest {
    @Test
    void getTarget() throws IOException {
        Position position= mock(Position.class);
        AmbushTargetStrategy a=new AmbushTargetStrategy();
        MapReader mapReader=new MapReader();
        Map map=mapReader.createMap("mapTest");

        Assertions.assertEquals(new Position(40, 12), a.getTarget(position, map));
        Pacman pacman=map.getPacman();

        pacman.setNextDirection(Direction.Up);
        pacman.nextDirection();
        map.setPacman(pacman);
        Assertions.assertEquals(new Position(-24, 60), a.getTarget(position, map));

        pacman.setNextDirection(Direction.Left);
        pacman.nextDirection();
        map.setPacman(pacman);
        Assertions.assertEquals(new Position(8, -36), a.getTarget(position, map));

        pacman.setNextDirection(Direction.Right);
        pacman.nextDirection();
        map.setPacman(pacman);
        Assertions.assertEquals(new Position(8, 60), a.getTarget(position, map));

        pacman.setNextDirection(Direction.None);
        pacman.nextDirection();
        map.setPacman(pacman);
        Assertions.assertEquals(new Position(-24, 60), a.getTarget(position, map));

    }
}
