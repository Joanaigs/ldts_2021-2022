package control;

import com.googlecode.lanterna.input.KeyStroke;
import model.Elements.Pacman;

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
            case ArrowUp:
                pacman.setDirection(pacman.moveUp());
                break;
            case ArrowDown:
                pacman.setDirection(pacman.moveDown());
                break;
            case ArrowLeft:
                pacman.setDirection(pacman.moveLeft());
                break;
            case ArrowRight:
                pacman.setDirection(pacman.moveRight());
                break;
        }
    }

}
