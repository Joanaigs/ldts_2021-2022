package g0902.model;

import g0902.Configuration;
import g0902.model.Game.GameModel;
import g0902.model.Game.Map.Map;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Ghost;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Cyan;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Orange;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Pink;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Red;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class GameModelTest {
    private Map map;
    private final List<Ghost> ghosts = new ArrayList<>();
    private Red red;
    private Pink pink;
    private Cyan cyan;
    private Orange orange;
    private Pacman pacman;
    private GameModel gameModel;
    final long deltatime = 20;

    @BeforeEach
    public void setUp() throws IOException {
        map = mock(Map.class);
        pacman = mock(Pacman.class);
        Position position = new Position(1, 1);
        Mockito.when(map.getPacman()).thenReturn(pacman);
        red = mock(Red.class);
        pink = mock(Pink.class);
        cyan = mock(Cyan.class);
        orange = mock(Orange.class);
        ghosts.add(red);
        ghosts.add(pink);
        ghosts.add(cyan);
        ghosts.add(orange);
        Mockito.when(map.getRed()).thenReturn(red);
        Mockito.when(map.getPink()).thenReturn(pink);
        Mockito.when(map.getCyan()).thenReturn(cyan);
        Mockito.when(map.getOrange()).thenReturn(orange);
        Mockito.when(pacman.getPosition()).thenReturn(position);
        Mockito.when(red.getPosition()).thenReturn(position);
        Mockito.when(pink.getPosition()).thenReturn(position);
        Mockito.when(cyan.getPosition()).thenReturn(position);
        Mockito.when(orange.getPosition()).thenReturn(position);
        gameModel = new GameModel("mapTest5");
    }

    @Test
    public void gameModelTest(){
        Assertions.assertEquals(true, gameModel.isRunning());
        Assertions.assertEquals(false, gameModel.hasLost());
    }

    @Test
    public void updateTest(){
        Assertions.assertEquals(8, gameModel.getPacman().getPosition().getRow());     //original pacman's position on the map
        Assertions.assertEquals(72, gameModel.getPacman().getPosition().getCol());
        Assertions.assertEquals(1, gameModel.getMap().getSmallCoins().size());        //initial amount of small coins on the map
        Assertions.assertEquals(1, gameModel.getMap().getPowerCoins().size());        //initial amount of power coins on the map
        Assertions.assertEquals(0, gameModel.getPacman().getScore());
        Assertions.assertEquals(3, gameModel.getPacman().getLives());
        Assertions.assertEquals(4, gameModel.getGhosts().size());
        gameModel.update(deltatime);
        Assertions.assertEquals(9, gameModel.getPacman().getPosition().getRow());     //pacman's position after update
        Assertions.assertEquals(72, gameModel.getPacman().getPosition().getCol());
        Assertions.assertEquals(0, gameModel.getMap().getSmallCoins().size());        //pacman ate a small coin
        Assertions.assertEquals(false, gameModel.smallCoinCollisions());
        Assertions.assertEquals(10, gameModel.getPacman().getScore());
        Assertions.assertEquals(1, gameModel.getMap().getPowerCoins().size());          //pacman didn't eat any power coin
        for (Ghost ghost : gameModel.getGhosts())
            Assertions.assertEquals(false, ghost.getFrightenedModeOn());
        Assertions.assertEquals(false, gameModel.getMap().getSmallCoins().isEmpty() && gameModel.getMap().getPowerCoins().isEmpty());
        Assertions.assertEquals(true, gameModel.isRunning());
        Assertions.assertEquals(false, gameModel.hasLost());
        Assertions.assertEquals(3, gameModel.getPacman().getLives());

    }

    @Test
    public void updateTestMocks(){
        gameModel.setPacman(pacman);
        gameModel.setGhosts(ghosts);
        gameModel.setMap(map);
        gameModel.update(deltatime);
        Mockito.verify(map, Mockito.times(10)).getSmallCoins();
        Mockito.verify(map, Mockito.times(3)).getPowerCoins();
        Mockito.verify(red, Mockito.times(1)).update(deltatime);
        Mockito.verify(pink, Mockito.times(1)).update(deltatime);
        Mockito.verify(cyan, Mockito.times(1)).update(deltatime);
        Mockito.verify(orange, Mockito.times(1)).update(deltatime);
        Mockito.verify(red, Mockito.times(6)).getFrightenedModeOn();
        Mockito.verify(pink, Mockito.times(6)).getFrightenedModeOn();
        Mockito.verify(cyan, Mockito.times(6)).getFrightenedModeOn();
        Mockito.verify(orange, Mockito.times(6)).getFrightenedModeOn();
    }

    @Test
    public void smallCoinCollisionsTest(){
        Assertions.assertTrue(gameModel.smallCoinCollisions());
    }

    @Test
    public void powerCoinCollisionsTest(){
        updateTest();
        gameModel.update(deltatime);
        Assertions.assertEquals(0, gameModel.getMap().getPowerCoins().size());
        Assertions.assertEquals(210, gameModel.getPacman().getScore());
        for (Ghost ghost : gameModel.getGhosts())
            Assertions.assertEquals(true, ghost.getFrightenedModeOn());
    }

    @Test
    public void ghostPacmanCollisionsTest(){
        powerCoinCollisionsTest();
        gameModel.getGhosts().get(0).setPosition(gameModel.getPacman().getPosition());
        gameModel.ghostPacmanCollisions(gameModel.getGhosts().get(0));
        Assertions.assertEquals(410, gameModel.getPacman().getScore());
        Assertions.assertEquals(400, gameModel.getGhosts().get(0).getGhostValue());
        Assertions.assertEquals(false, gameModel.getGhosts().get(0).getFrightenedModeOn());
        Assertions.assertEquals(gameModel.getGhosts().get(0).getBeginPosition(), gameModel.getGhosts().get(0).getPosition());
    }

    @Test
    public void resetTest() {
        gameModel.getGhosts().get(0).setPosition(gameModel.getPacman().getPosition());
        Assertions.assertEquals(false, gameModel.getGhosts().get(0).getFrightenedModeOn());
        Assertions.assertEquals(3, gameModel.getPacman().getLives());
        gameModel.ghostPacmanCollisions(gameModel.getGhosts().get(0));
        Assertions.assertEquals(2, gameModel.getPacman().getLives());
        Assertions.assertEquals(Direction.Down, gameModel.getPacman().getCurrentDirection());
        Assertions.assertEquals(gameModel.getPacman().getBeginPosition(), gameModel.getPacman().getPosition());
        for (Ghost ghost : gameModel.getGhosts()) {
            Assertions.assertEquals(ghost.getBeginPosition(), ghost.getPosition());
            Assertions.assertEquals(false, ghost.getFrightenedModeOn());
        }
    }

    @Test
    public void resetTestMocks(){
        gameModel.setPacman(pacman);
        gameModel.setGhosts(ghosts);
        gameModel.resetGame();
        Mockito.verify(pacman, Mockito.times(1)).setCurrentDirection(Direction.Down);
        Mockito.verify(pacman, Mockito.times(1)).setPosition(pacman.getBeginPosition());
        Mockito.verify(red, Mockito.times(1)).getFrightenedModeOn();
        Mockito.verify(pink, Mockito.times(1)).getFrightenedModeOn();
        Mockito.verify(cyan, Mockito.times(1)).getFrightenedModeOn();
        Mockito.verify(orange, Mockito.times(1)).getFrightenedModeOn();
        Mockito.verify(red, Mockito.times(0)).setFrightenedModeOff();
        Mockito.verify(pink, Mockito.times(0)).setFrightenedModeOff();
        Mockito.verify(cyan, Mockito.times(0)).setFrightenedModeOff();
        Mockito.verify(orange, Mockito.times(0)).setFrightenedModeOff();
        Mockito.when(red.getFrightenedModeOn()).thenReturn(true);
        Mockito.when(pink.getFrightenedModeOn()).thenReturn(true);
        Mockito.when(cyan.getFrightenedModeOn()).thenReturn(true);
        Mockito.when(orange.getFrightenedModeOn()).thenReturn(true);
        gameModel.resetGame();
        Mockito.verify(red, Mockito.times(1)).setFrightenedModeOff();
        Mockito.verify(pink, Mockito.times(1)).setFrightenedModeOff();
        Mockito.verify(cyan, Mockito.times(1)).setFrightenedModeOff();
        Mockito.verify(orange, Mockito.times(1)).setFrightenedModeOff();
    }

    @Test
    public void zeroLivesTest(){
        Pacman pacman=gameModel.getPacman();
        pacman.setLives(1);
        gameModel.setPacman(pacman);
        gameModel.getGhosts().get(0).setPosition(gameModel.getPacman().getPosition());
        gameModel.ghostPacmanCollisions(gameModel.getGhosts().get(0));
        Assertions.assertEquals(true, gameModel.hasLost());
        Assertions.assertEquals(false, gameModel.isRunning());
    }

    @AfterEach
    public void stop(){
        Configuration.getInstance().stopAllMusic();
    }
}
