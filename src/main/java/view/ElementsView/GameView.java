package view.ElementsView;

import com.googlecode.lanterna.screen.Screen;
import model.Elements.Coins.PowerCoin;
import model.Elements.Coins.SmallCoin;
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

        for(WallView wall : wallsViewers)
            wall.draw();

        for( PowerCoin powerCoin : getModel().getMap().getPowerCoins())
            new PowerCoinView(powerCoin, graphics).draw();

        for( SmallCoin smallCoin : getModel().getMap().getSmallCoins())
            new SmallCoinView(smallCoin, graphics).draw();

        pacmanViewer.draw();

        getScreen().refresh(Screen.RefreshType.AUTOMATIC);

    }
}
