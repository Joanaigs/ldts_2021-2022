package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import g0902.model.Direction;
import g0902.model.Game.MapElements.Pacman;

public class PacmanController implements Observer {
    private Pacman pacman;

    public PacmanController(Pacman pacman){
        this.pacman = pacman;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp    -> pacman.setDirection(Direction.Up);
            case ArrowDown  -> pacman.setDirection(Direction.Down);
            case ArrowLeft  -> pacman.setDirection(Direction.Left);
            case ArrowRight -> pacman.setDirection(Direction.Right);
        }
    }

}
