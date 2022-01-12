package g0902.model.Elements.Ghosts.MoveMode;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import g0902.model.Elements.Direction;
import g0902.model.Elements.Ghosts.Ghost;
import g0902.model.Elements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import g0902.model.Elements.Ghosts.Types.Cyan;
import g0902.model.Elements.Ghosts.Types.Orange;
import g0902.model.Elements.Ghosts.Types.Pink;
import g0902.model.Elements.Ghosts.Types.Red;
import g0902.model.Maps.Builders.MapBuilder;
import g0902.model.Maps.Builders.MapReader;
import g0902.model.Maps.Map;
import g0902.model.Menu.EndScreenModel;
import g0902.view.ViewEndScreen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class FrightenedModeTest {
    private Red red;
    private Pink pink;
    private Cyan cyan;
    private Orange orange;

    @BeforeEach
    void setup() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        Map map = mapbuilder.createMap("map");
        this.red=new Red(map.getCyan().getPosition());
        red.setMap(map);
        this.pink=new Pink(map.getCyan().getPosition());
        pink.setMap(map);
        this.orange=new Orange(map.getOrange().getPosition());
        orange.setMap(map);
        this.cyan=new Cyan(map.getCyan().getPosition());
        cyan.setMap(map);
    }

    @Test
    void cyanMoveSides(){
        cyan.update(20);
        cyan.setFrightenedModeOn();
        cyan.update(20);
        cyan.setCurrentDirection(cyan.getFrightenedBehaviour().frightened(20));
        Assertions.assertEquals(Direction.Left, cyan.getCurrentDirection()); //they turn 180 degrees

    }
    @Test
    void cyanMoveVertical(){
        cyan.setCurrentDirection(Direction.Up);
        cyan.setFrightenedModeOn();
        cyan.update(20);
        cyan.setCurrentDirection(cyan.getFrightenedBehaviour().frightened(20));
        Assertions.assertEquals(Direction.Down, cyan.getCurrentDirection()); //they turn 180 degrees
    }

    @Test
    void orangeMoveSides(){
        orange.update(20);
        orange.setFrightenedModeOn();
        orange.update(20);
        orange.setCurrentDirection(orange.getFrightenedBehaviour().frightened(20));
        Assertions.assertEquals(Direction.Right, orange.getCurrentDirection()); //they turn 180 degrees
    }

    @Test
    void orangeMoveVertical(){
        orange.setCurrentDirection(Direction.Down);
        orange.setFrightenedModeOn();
        orange.update(20);
        orange.setCurrentDirection(orange.getFrightenedBehaviour().frightened(20));
        Assertions.assertEquals(Direction.Up, orange.getCurrentDirection()); //they turn 180 degrees
    }

    @Test
    void pinkMoveSide(){
        pink.update(20);
        pink.setFrightenedModeOn();
        pink.update(20);
        pink.setCurrentDirection(pink.getFrightenedBehaviour().frightened(20));
        Assertions.assertEquals(Direction.Right, pink.getCurrentDirection()); //they turn 180 degrees

    }

    @Test
    void pinkMoveVertical(){
        pink.setCurrentDirection(Direction.Up);
        pink.setFrightenedModeOn();
        pink.update(20);
        pink.setCurrentDirection(pink.getFrightenedBehaviour().frightened(20));
        Assertions.assertEquals(Direction.Down, pink.getCurrentDirection()); //they turn 180 degrees
    }

    @Test
    void redMoveSides(){
        red.update(20);
        red.setFrightenedModeOn();
        red.update(20);
        red.setCurrentDirection(red.getFrightenedBehaviour().frightened(20));
        Assertions.assertEquals(Direction.Left, red.getCurrentDirection());
    }

    @Test
    void redMoveVertical(){
        red.setCurrentDirection(Direction.Down);
        red.setFrightenedModeOn();
        red.update(20);
        red.setCurrentDirection(red.getFrightenedBehaviour().frightened(20));
        Assertions.assertEquals(Direction.Up, red.getCurrentDirection()); //they turn 180 degrees
    }

    @Test
    void getRandomNumberTest(){
        FrightenedMode frightenedMode = new FrightenedMode(red);
        int min = 4;
        int max = 9;
        int randNum = frightenedMode.getRandomNumberInRange(4, 9);
        Assertions.assertTrue(randNum>=4 && randNum<=9);
    }
}
