package g0902.model.Elements.Ghosts;

import g0902.model.Elements.Direction;
import g0902.model.Elements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.ChaseStrategy;
import g0902.model.Elements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.RandomChaseStrategy;
import g0902.model.Elements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.TargetChaseStrategy;
import g0902.model.Elements.Ghosts.MoveMode.ChaseMode.TargetStrategys.AggressiveTargetStrategy;
import g0902.model.Elements.Ghosts.MoveMode.ChaseMode.TargetStrategys.AmbushTargetStrategy;
import g0902.model.Elements.Ghosts.MoveMode.ChaseMode.TargetStrategys.PatrolTargetStrategy;
import g0902.model.Elements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import g0902.model.Elements.Ghosts.MoveMode.ScatterMode.ScatterBottomLeft;
import g0902.model.Elements.Ghosts.MoveMode.ScatterMode.ScatterTopLeft;
import g0902.model.Elements.Ghosts.MoveMode.ScatterMode.ScatterTopRight;
import g0902.model.Maps.Builders.MapBuilder;
import g0902.model.Maps.Builders.MapReader;
import g0902.model.Maps.Map;
import g0902.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GhostsTest extends Assertions {
    Map map;
    Ghost ghost;

    @BeforeEach
    public void createMap() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        map = mapbuilder.createMap("mapTest");
        ghost = new Ghost(new Position(3*8, 3*12));
        // using a diferent map then the one used in the game, so is easier to test
    }

    // The following 4 tests, test if each ghost is being read correctly
    @Test
    void readRedTest() throws IOException {
        assertEquals(map.getRed().getPosition(), new Position(1 * 8+1, 2 * 12));
    }

    @Test
    void readPinkTest() throws IOException {
        assertEquals(map.getPink().getPosition(), new Position(1 * 8+1, 3 * 12));
    }

    @Test
    void readOrangeTest() throws IOException {
        assertEquals(map.getOrange().getPosition(), new Position(1 * 8+1, 4 * 12));
    }

    @Test
    void readCyanTest() throws IOException {
        assertEquals(map.getCyan().getPosition(), new Position(1 * 8+1, 5 * 12));
    }

    @Test
    void changePositionTest(){
        long deltatime = -8/50;
        double velocity = 50;
        Position pos1 = ghost.move(deltatime, Direction.Up);
        Position pos2 = new Position((3*8)-(int)(velocity*deltatime/1000), 3*12);
        Assertions.assertTrue(pos1.equals(pos2));
    }

    @Test
    void update() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        map = mapbuilder.createMap("map");
        ghost = map.getPink();
        TargetChaseStrategy targetChaseStrategy=new TargetChaseStrategy(new AggressiveTargetStrategy(), ghost);
        targetChaseStrategy.setMap(map);
        ScatterTopRight scatterBottomLeft=new ScatterTopRight(ghost);
        scatterBottomLeft.setMap(map);
        FrightenedMode frightenedMode=new FrightenedMode(ghost);
        frightenedMode.setMap(map);
        ghost.setChaseStrategy(targetChaseStrategy);
        ghost.setScatterBehaviour(scatterBottomLeft);
        ghost.setFrightenedBehaviour(frightenedMode);
        ghost.setCounterTime(26980);
        ghost.update(20);
        assertEquals(Direction.Right, ghost.getCurrentDirection());
        ghost.move(20, Direction.Down);
        ghost.setCounterTime(26979);
        ghost.update(20);
        assertEquals(Direction.Right, ghost.getCurrentDirection());
        ghost.setCounterTime(8981);
        ghost.setFrightenedModeOn();
        ghost.update(20);
        assertEquals(Direction.Left, ghost.getCurrentDirection());
        assertEquals(new Position(105,205), ghost.getPosition());
        ghost.setFrightenedTime(9001);
        ghost.updateScore();
        assertEquals(400, ghost.getScore());
        assertEquals(new Position(105,204), ghost.getBeginPosition());
        ghost.update(20);
        assertEquals(false, ghost.getFrightenedModeOn());
        assertEquals(9001, ghost.getFrightenedTime());
    }
    @Test
    void move(){
        assertEquals(new Position(24,35), ghost.move(20, Direction.Left));
        assertEquals(new Position(24,37), ghost.move(20, Direction.Right));
        assertEquals(new Position(23,36), ghost.move(20, Direction.Up));
        assertEquals(new Position(25,36), ghost.move(20, Direction.Down));
        assertEquals(new Position(24,36), ghost.move(20, Direction.None));
    }

}
