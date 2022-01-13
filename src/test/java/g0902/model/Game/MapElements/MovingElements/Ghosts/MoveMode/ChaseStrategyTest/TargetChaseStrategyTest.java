package g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseStrategyTest;

import g0902.model.Direction;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.TargetChaseStrategy;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Cyan;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseMode.TargetStrategys.AggressiveTargetStrategy;
import g0902.model.Game.Map.Builders.MapReader;
import g0902.model.Game.Map.Map;
import g0902.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.round;
import static org.mockito.Mockito.mock;

public class TargetChaseStrategyTest {
    Map map;
    Cyan cyan;
    ArrayList<Double> dists;
    @BeforeEach
    void setUp() throws IOException {
        MapReader mapReader=new MapReader();
        map=mapReader.createMap("map");
        cyan= (Cyan) map.getCyan();
        dists=new ArrayList<>(
                Arrays.asList(8.0, 3.0, 5.0));
    }
    /*
    @Test
    void chaseTest(){
        cyan.setCurrentDirection(Direction.Right);
        TargetChaseStrategy a=new TargetChaseStrategy(new AggressiveTargetStrategy(), cyan);
        Assertions.assertEquals(Direction.Right,  a.chase(20));
        Assertions.assertEquals(3.0, round(a.calculateDistance(new Position(1,1), new Position(3, 3))));
        Assertions.assertEquals(1, a.correspondenceToSmallestDistance(dists));

        cyan.setCurrentDirection(Direction.Left);
        TargetChaseStrategy a1=new TargetChaseStrategy(new AggressiveTargetStrategy(), cyan);
        Assertions.assertEquals(new ArrayList<>(Arrays.asList(Direction.Down, Direction.Left, Direction.None, Direction.Up)), a1.removeOppositeDirections(new ArrayList<>(
                Arrays.asList(Direction.Down, Direction.Left, Direction.None, Direction.Up, Direction.Right))));

        cyan.setCurrentDirection(Direction.Right);
        TargetChaseStrategy a2=new TargetChaseStrategy(new AggressiveTargetStrategy(), cyan);
        Assertions.assertEquals(new ArrayList<>(Arrays.asList(Direction.Down, Direction.None, Direction.Up, Direction.Right)), a2.removeOppositeDirections(new ArrayList<>(
                Arrays.asList(Direction.Down, Direction.Left, Direction.None, Direction.Up, Direction.Right))));

        cyan.setCurrentDirection(Direction.Up);
        TargetChaseStrategy a3=new TargetChaseStrategy(new AggressiveTargetStrategy(), cyan);
        Assertions.assertEquals(new ArrayList<>(Arrays.asList(Direction.Left, Direction.None, Direction.Up, Direction.Right)), a3.removeOppositeDirections(new ArrayList<>(
                Arrays.asList(Direction.Down, Direction.Left, Direction.None, Direction.Up, Direction.Right))));

        cyan.setCurrentDirection(Direction.Down);
        TargetChaseStrategy a4=new TargetChaseStrategy(new AggressiveTargetStrategy(), cyan);
        Assertions.assertEquals(new ArrayList<>(Arrays.asList(Direction.Down, Direction.Left, Direction.None, Direction.Right)), a4.removeOppositeDirections(new ArrayList<>(
                Arrays.asList(Direction.Down, Direction.Left, Direction.None, Direction.Up, Direction.Right))));

        cyan.setCurrentDirection(Direction.None);
        TargetChaseStrategy a5=new TargetChaseStrategy(new AggressiveTargetStrategy(), cyan);
        Assertions.assertEquals(new ArrayList<>(Arrays.asList(Direction.Down, Direction.Left, Direction.Up, Direction.Right)), a5.removeOppositeDirections(new ArrayList<>(
                Arrays.asList(Direction.Down, Direction.Left, Direction.None, Direction.Up, Direction.Right))));

        Assertions.assertEquals(new ArrayList<>(Arrays.asList(Direction.Left, Direction.Right)), a.removeCollidingDirections(new ArrayList<>(Arrays.asList(Direction.Down, Direction.Left, Direction.Up, Direction.Right)), 20));
    }
    */

}
