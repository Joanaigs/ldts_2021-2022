package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import g0902.model.Direction;
import g0902.model.Game.MapElements.MovingElements.Pacman;

import static java.lang.System.exit;

public class PacmanController implements Observer {
    private final Pacman pacman;

    public PacmanController(Pacman pacman){
        this.pacman = pacman;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp    -> pacman.setNextDirection(Direction.Up);
            case ArrowDown  -> pacman.setNextDirection(Direction.Down);
            case ArrowLeft  -> pacman.setNextDirection(Direction.Left);
            case ArrowRight -> pacman.setNextDirection(Direction.Right);
            case EOF -> exit(0);
        }
    }
}
