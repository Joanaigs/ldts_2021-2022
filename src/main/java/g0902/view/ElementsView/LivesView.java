package g0902.view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Direction;
import g0902.model.Game.GameModel;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import g0902.model.Position;

import java.io.IOException;

public class LivesView extends View{
    GameModel gameModel;

    public LivesView(GameModel gameModel, TextGraphics graphics) {
        super(graphics);
        this.gameModel =  gameModel;
    }

    @Override
    public void draw() throws IOException {
        Pacman pacman = new Pacman( new Position( gameModel.getMap().getHeight() + 3, 340 ));
        pacman.setCurrentDirection(Direction.Right);

        for( int i=0; i < gameModel.getMap().getPacman().getLives(); i++) {
            pacman.setPosition(new Position( pacman.getPosition().getRow(), pacman.getPosition().getCol()+ 27 ));
            drawPacman(pacman);
        }

    }

    public void drawPacman(Pacman pacman){
        PacmanView pacmanView = new PacmanView(pacman, graphics);
        pacmanView.draw();
    }
}
