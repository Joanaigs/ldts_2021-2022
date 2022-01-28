package g0902.view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Direction;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import g0902.model.Position;


public class LivesView extends View{
    final Pacman pacman;

    public LivesView(Pacman pacman, TextGraphics graphics) {
        super(graphics);
        this.pacman = pacman;
    }

    @Override
    public void draw() {
        Pacman newPacman = new Pacman( new Position( 39*8 + 3, 340 ));
        newPacman.setCurrentDirection(Direction.Right);

        for( int i=0; i < pacman.getLives(); i++) {
            newPacman.setPosition(new Position( newPacman.getPosition().getRow(), newPacman.getPosition().getCol()+ 27 ));
            drawPacman(newPacman);
        }

    }

    public void drawPacman(Pacman pacman){
        PacmanView pacmanView = new PacmanView(pacman, graphics);
        pacmanView.draw();
    }
}
