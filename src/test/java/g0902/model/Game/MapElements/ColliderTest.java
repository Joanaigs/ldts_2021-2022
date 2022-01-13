package g0902.model.Game.MapElements;

import g0902.model.Game.MapElements.MovingElements.Pacman;
import g0902.view.ElementsView.Collider;
import g0902.model.Game.MapElements.Coins.Coin;
import g0902.model.Game.MapElements.Coins.PowerCoin;
import g0902.model.Game.MapElements.Coins.SmallCoin;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Ghost;
import g0902.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ColliderTest extends Assertions {

    @Test
    //Tests if the pacman collides with wall.
    void pacmanCollidesWall() throws IOException {
        Pacman pacman = new Pacman(new Position(3*8+1, 3*12-1));
        Wall wall = new Wall(new Position(3*8+1, 3*12-1),12, 8);
        Collider wallCollider = new Collider(wall.getPosition(), wall.getCollider().getWidth(), wall.getCollider().getHeight());
        Collider pacmanCollider = new Collider(pacman.getPosition(), pacman.getCollider().getWidth(), pacman.getCollider().getHeight());

        Assertions.assertTrue(wallCollider.collision(pacmanCollider));
    }

    @Test
    //Tests if the pacman collides with wall.
    void pacmanNotCollidesWall() throws IOException {
        Pacman pacman = new Pacman(new Position(1*8+1, 3*12-1));
        Wall wall = new Wall(new Position(3*8+1, 3*12-1),12, 8);
        Collider wallCollider = new Collider(wall.getPosition(), wall.getCollider().getWidth(), wall.getCollider().getHeight());
        Collider pacmanCollider = new Collider(pacman.getPosition(), pacman.getCollider().getWidth(), pacman.getCollider().getHeight());

        Assertions.assertFalse(wallCollider.collision(pacmanCollider));
    }

    @Test
        //Tests if the pacman collides with coin.
    void pacmanNotCollidesCoin() throws IOException {
        Pacman pacman = new Pacman(new Position(1*8+1, 3*12-1));
        Coin coin1 = new PowerCoin(new Position(3*8+1, 3*12-1));
        pacman.setPosition(new Position(1*8+1, 3*12-1));
        Coin coin2 = new SmallCoin(new Position(1*8+1, 3*12-1));
        Collider coin1Collider = new Collider(coin1.getPosition(), coin1.getCollider().getWidth(), coin1.getCollider().getHeight());
        Collider pacmanCollider = new Collider(pacman.getPosition(), pacman.getCollider().getWidth(), pacman.getCollider().getHeight());
        Collider coin2Collider = new Collider(coin2.getPosition(), coin2.getCollider().getWidth(), coin2.getCollider().getHeight());
        Assertions.assertFalse(coin1Collider.collision(pacmanCollider));
        Assertions.assertTrue(coin2Collider.collision(pacmanCollider));
    }


    @Test
        //Tests if the pacman collides with coin.
    void ghostsNCollidesGhost() throws IOException {
        Pacman pacman = new Pacman(new Position(1*8+1, 3*12-1));
        Ghost ghost1 = new Ghost(new Position(3*8+1, 3*12-1));
        pacman.setPosition(new Position(1*8+1, 3*12-1));
        Ghost ghost2 = new Ghost(new Position(1*8+1, 3*12-1));

        Collider ghost1Collider = new Collider(ghost1.getPosition(), ghost1.getCollider().getWidth(), ghost1.getCollider().getHeight());
        Collider pacmanCollider = new Collider(pacman.getPosition(), pacman.getCollider().getWidth(), pacman.getCollider().getHeight());
        Collider ghost2Collider = new Collider(ghost2.getPosition(), ghost2.getCollider().getWidth(), ghost2.getCollider().getHeight());
        Assertions.assertFalse(ghost1Collider.collision(pacmanCollider));
        Assertions.assertTrue(ghost2Collider.collision(pacmanCollider));
    }

}
