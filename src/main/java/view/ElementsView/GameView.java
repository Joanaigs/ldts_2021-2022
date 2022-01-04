package view.ElementsView;

import com.googlecode.lanterna.screen.Screen;
import model.Elements.Coins.PowerCoin;
import model.Elements.Coins.SmallCoin;
import model.Elements.Wall;
import model.GameModel;
import view.ElementsView.Coins.PowerCoinView;
import view.ElementsView.Coins.SmallCoinView;
import view.ElementsView.Ghosts.CyanView;
import view.ElementsView.Ghosts.OrangeView;
import view.ElementsView.Ghosts.PinkView;
import view.ElementsView.Ghosts.RedView;
import view.ElementsView.PacmanView;
import view.ElementsView.WallView;
import view.Viewer;

import java.io.IOException;

public  class GameView extends Viewer<GameModel> {
    private final PacmanView pacmanViewer;
    private final WallView[] wallsViewers;
    private final RedView redViewer;
    private final PinkView pinkViewer;
    private final OrangeView orangeViewer;
    private final CyanView cyanViewer;

    public GameView(GameModel gameModel) throws IOException {
        super(gameModel);
        pacmanViewer = new PacmanView(gameModel.getMap().getPacman(), graphics);
        wallsViewers = new WallView[gameModel.getMap().getWalls().size()];
        redViewer = new RedView(gameModel.getMap().getRed(), graphics);
        pinkViewer = new PinkView(gameModel.getMap().getPink(), graphics);
        orangeViewer = new OrangeView(gameModel.getMap().getOrange(), graphics);
        cyanViewer = new CyanView(gameModel.getMap().getCyan(), graphics);

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

        for( SmallCoin smallCoin : getModel().getMap().getSmallCoins().values())
            new SmallCoinView(smallCoin, graphics).draw();

        redViewer.draw();
        pinkViewer.draw();
        orangeViewer.draw();
        cyanViewer.draw();
        pacmanViewer.draw();
        getScreen().refresh(Screen.RefreshType.AUTOMATIC);
    }
}