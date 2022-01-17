package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import g0902.model.Direction;
import g0902.model.Game.GameModel;
import g0902.model.Game.MapElements.MovingElements.Pacman;

import static java.lang.System.exit;

public class PacmanController implements Observer {
    private final Pacman pacman;
    private GameModel gameModel;
    public PacmanController(Pacman pacman, GameModel gameModel){
        this.pacman = pacman;
        this.gameModel=gameModel;
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
            case Enter -> gameModel.setRunning(false);
        }
    }
}
