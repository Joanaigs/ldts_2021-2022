package g0902.model.Game.MapElements.MovingElements.Ghosts;


import g0902.Constants;
import g0902.model.Direction;
import g0902.model.Game.Map.Builders.MapBuilder;
import g0902.model.Game.Map.Builders.MapReader;
import g0902.model.Game.Map.Map;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.TargetChaseStrategy;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseMode.TargetStrategys.AggressiveTargetStrategy;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ScatterMode.ScatterTopRight;
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
    void update() throws IOException {
        //setting up
        MapBuilder mapbuilder = new MapReader();
        map = mapbuilder.createMap("map");
        ghost = map.getPink();
        TargetChaseStrategy targetChaseStrategy=new TargetChaseStrategy(new AggressiveTargetStrategy(), ghost);
        ScatterTopRight scatterBottomLeft=new ScatterTopRight(ghost);
        FrightenedMode frightenedMode=new FrightenedMode(ghost);
        ghost.setChaseStrategy(targetChaseStrategy);
        ghost.setScatterBehaviour(scatterBottomLeft);
        ghost.setFrightenedBehaviour(frightenedMode);

        //testing different modes in different times
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

        assertEquals(new Position(105,204), ghost.getBeginPosition());

        //Frightened mode
        ghost.setFrightenedModeOn();
        ghost.update(20);
        assertEquals(true, ghost.getFrightenedModeOn());
        assertEquals(20, ghost.getFrightenedTime());
        assertEquals(Direction.Right, ghost.getCurrentDirection());
        ghost.setFrightenedTime(9001);
        ghost.update(20);
        assertEquals(false, ghost.getFrightenedModeOn());
        assertEquals(9001, ghost.getFrightenedTime());

        //test fixPassScreenBorder
        ghost.setPosition(new Position(0, Constants.SCREEN_WIDTH));
        ghost.update(20);
        assertEquals(new Position(1,-35), ghost.getPosition());

        //test updateGhostValue
        ghost.updateGhostValue();
        assertEquals(400, ghost.getGhostValue());
    }



}
