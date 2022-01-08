package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import g0902.model.Elements.Pacman;

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
            case ArrowUp    -> pacman.setDirection(pacman.moveUp());
            case ArrowDown  -> pacman.setDirection(pacman.moveDown());
            case ArrowLeft  -> pacman.setDirection(pacman.moveLeft());
            case ArrowRight -> pacman.setDirection(pacman.moveRight());
        }
    }

}
