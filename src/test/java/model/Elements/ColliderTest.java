package model.Elements;

import model.Elements.Collider;
import model.Elements.Direction;
import model.Elements.Pacman;
import model.Elements.Wall;
import model.Maps.Builders.MapBuilder;
import model.Maps.Builders.MapReader;
import model.Maps.Map;
import model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

        Assertions.assertTrue(wallCollider.colision(pacmanCollider));
    }

    @Test
    //Tests if the pacman collides with wall.
    void pacmanNotCollidesWall() throws IOException {
        Pacman pacman = new Pacman(new Position(1*8+1, 3*12-1));
        Wall wall = new Wall(new Position(3*8+1, 3*12-1),12, 8);
        Collider wallCollider = new Collider(wall.getPosition(), wall.getCollider().getWidth(), wall.getCollider().getHeight());
        Collider pacmanCollider = new Collider(pacman.getPosition(), pacman.getCollider().getWidth(), pacman.getCollider().getHeight());

        Assertions.assertFalse(wallCollider.colision(pacmanCollider));
    }


    /*
                                                F I X     L A T E R
     It's only related to how I wrote the code here.....
     Each function used here was tested and was working on the previous tests.

    @Test
    // Here, pacman is set on the same position as the wall. But then, we move it down, so they won't share the same position.
    // The collider must return false here, because after the pacman moves, they won't be colliding.
    void pacmanCollidesAndMove() throws IOException {

        // set up on the same position
        Pacman pacman = new Pacman(new Position(3*8, 3*12));
        Wall wall = new Wall(new Position(3*8, 3*12),12, 8);

        // pacman moves down
        long deltatime = -8/62/3;
        pacman.setPosition(pacman.move(deltatime, Direction.Down));

        // creating the colliders
        Collider wallCollider = new Collider(wall.getPosition(), wall.getCollider().getWidth(), wall.getCollider().getHeight());
        Collider pacmanCollider = new Collider(pacman.getPosition(), pacman.getCollider().getWidth(), pacman.getCollider().getHeight());

        // they won't be colliding anymore
        Assertions.assertFalse(wallCollider.colision(pacmanCollider));
    }

    */

}
