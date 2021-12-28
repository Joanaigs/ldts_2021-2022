package view.ElementsView;

import com.googlecode.lanterna.screen.Screen;
import model.Elements.Wall;
import model.GameModel;
import view.Viewer;

import java.io.IOException;

public class GameView extends Viewer<GameModel> {
    private final PacmanView pacmanViewer;
    private final WallView[] wallsViewers;

    public GameView(GameModel gameModel) throws IOException {
        super(gameModel);
        pacmanViewer = new PacmanView(gameModel.getMap().getPacman(), graphics);
        wallsViewers = new WallView[gameModel.getMap().getWalls().size()];

        int i = 0;
        for( Wall wall : gameModel.getMap().getWalls())
            wallsViewers[i++]= new WallView(wall, graphics);
    }

    @Override
    public void draw() throws IOException {
        getScreen().clear();

        for( WallView wall : wallsViewers)
            wall.draw();


        pacmanViewer.draw();
        getScreen().refresh(Screen.RefreshType.AUTOMATIC);

    }
}
