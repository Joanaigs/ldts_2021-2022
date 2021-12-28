package view.ElementsView;

import com.googlecode.lanterna.screen.Screen;
import model.Elements.PowerCoin;
import model.Elements.SmallCoin;
import model.Elements.Wall;
import model.GameModel;
import view.Viewer;

import java.io.IOException;

public class GameView extends Viewer<GameModel> {
    private final PacmanView pacmanViewer;
    private final WallView[] wallsViewers;
    private final PowerCoinView[] powerCoinViewers;
    private final SmallCoinView[] smallCoinViewers;

    public GameView(GameModel gameModel) throws IOException {
        super(gameModel);
        pacmanViewer = new PacmanView(gameModel.getMap().getPacman(), graphics);
        wallsViewers = new WallView[gameModel.getMap().getWalls().size()];
        powerCoinViewers = new PowerCoinView[gameModel.getMap().getPowerCoins().size()];
        smallCoinViewers = new SmallCoinView[gameModel.getMap().getSmallCoins().size()];

        int i = 0;
        for( Wall wall : gameModel.getMap().getWalls())
            wallsViewers[i++]= new WallView(wall, graphics);

        i = 0;
        for( PowerCoin powerCoin : gameModel.getMap().getPowerCoins())
            powerCoinViewers[i++]= new PowerCoinView(powerCoin, graphics);

        i = 0;
        for( SmallCoin smallCoin : gameModel.getMap().getSmallCoins())
            smallCoinViewers[i++]= new SmallCoinView(smallCoin, graphics);
    }

    @Override
    public void draw() throws IOException {
        getScreen().clear();

        for(WallView wall : wallsViewers)
            wall.draw();

        pacmanViewer.draw();

        for(PowerCoinView powerCoin : powerCoinViewers)
            powerCoin.draw();

        for(SmallCoinView smallCoin : smallCoinViewers)
            smallCoin.draw();

        getScreen().refresh(Screen.RefreshType.AUTOMATIC);

    }
}
