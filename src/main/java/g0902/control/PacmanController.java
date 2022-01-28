package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import g0902.model.Direction;
import g0902.model.Game.GameModel;
import g0902.model.Game.MapElements.MovingElements.Pacman;

import static java.lang.System.exit;

public class PacmanController implements Observer {
    private final Pacman pacman;
    private final GameModel gameModel;
    public PacmanController(Pacman pacman, GameModel gameModel){
        this.pacman = pacman;
        this.gameModel=gameModel;
    }

    public Pacman getPacman() {
        return pacman;
    }

    @Override
    @SuppressWarnings("MissingCasesInEnumSwitch")
    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp    :
                pacman.setNextDirection(Direction.Up);
                break;
            case ArrowDown  :
                pacman.setNextDirection(Direction.Down);
                break;
            case ArrowLeft  :
                pacman.setNextDirection(Direction.Left);
                break;
            case ArrowRight :
                pacman.setNextDirection(Direction.Right);
                break;
            case Character :
                if(key.getCharacter()=='x' ||  key.getCharacter()=='X')
                    exit(0);
                break;
            case Enter:
                    gameModel.setRunning(false);
                    gameModel.setLost(true);
                    break;
        }
    }
}
