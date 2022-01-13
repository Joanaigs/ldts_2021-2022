package g0902.model.Game.MapElements;

import g0902.Constants;
import g0902.model.Direction;
import g0902.model.Game.MapElements.MovingElements.MovingElement;
import g0902.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MovingElementTest extends Assertions {
    MovingElement element;

    @BeforeEach
    public void createMovingElement(){
        Position pos = new Position(3 * 8 + 1, 3 * 12 - 1);
        element = new MovingElement(pos, 34, 15);
        element.setVelocity(100, 50);
    }


    @Test
    void moveTest(){
        long deltatime = -8/62/3;
        double velocityY = 50;
        Position pos1 = element.move(deltatime, Direction.Up);
        Position pos2 = new Position((3*8+1)-(int)(velocityY*deltatime/1000), 3*12-1);
        Assertions.assertTrue(pos1.equals(pos2));

        /*
        Assertions.assertEquals(new Position(3*8+1-(50*20/1000), 3*12-1), element.move(20, Direction.Up));
        Assertions.assertEquals(new Position(3*8+1+(50*20/1000), 3*12-1), element.move(20, Direction.Down));
        Assertions.assertEquals(new Position(3*8+1, (int)3*12-3), element.move(20, Direction.Left));
        Assertions.assertEquals(new Position(3*8+1, (int)3*12+1), element.move(20, Direction.Right));
        Assertions.assertEquals(new Position(3*8+1, 3*12-1), element.move(20, Direction.None));
        */
    }

    @Test
    void NotPassBorderRight(){
        Position pos = new Position(0, Constants.SCREEN_WIDTH-1);
        element.setPosition(pos);

        element.fixPassScreenBorder();

        assertEquals(element.getPosition().getCol(), Constants.SCREEN_WIDTH-1);
        assertEquals(element.getPosition().getRow(), 0);

    }

    @Test
    void PassBorderRight(){
        Position pos = new Position(0, Constants.SCREEN_WIDTH);

        element.setPosition(pos);
        element.fixPassScreenBorder();

        assertEquals(element.getPosition().getCol(), -element.getWidth());
        assertEquals(element.getPosition().getRow(), 0);
    }

    @Test
    void NotPassBorderLeft(){
        Position pos = new Position(0, -element.getWidth()+1);

        element.setPosition(pos);
        element.fixPassScreenBorder();

        assertEquals(element.getPosition().getCol(), -element.getWidth()+1);
        assertEquals(element.getPosition().getRow(), 0);

    }

    @Test
    void PassBorderLeft(){
        Position pos = new Position(0, -element.getWidth());

        element.setPosition(pos);
        element.fixPassScreenBorder();

        assertEquals(element.getPosition().getCol(), Constants.SCREEN_WIDTH);
        assertEquals(element.getPosition().getRow(), 0);
    }

}
