package g0902.view.ElementsView;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import g0902.model.Game.MapElements.Coins.PowerCoin;
import g0902.model.Game.MapElements.Coins.SmallCoin;
import g0902.model.Game.MapElements.Wall;
import g0902.model.Game.GameModel;
import g0902.view.ElementsView.Coins.PowerCoinView;
import g0902.view.ElementsView.Coins.SmallCoinView;
import g0902.view.ElementsView.Ghosts.CyanView;
import g0902.view.ElementsView.Ghosts.OrangeView;
import g0902.view.ElementsView.Ghosts.PinkView;
import g0902.view.ElementsView.Ghosts.RedView;
import g0902.view.Viewer;

import java.io.IOException;

public  class GameView extends Viewer<GameModel> {
    private  PacmanView pacmanViewer;
    private  WallView[] wallsViewers;
    private  RedView redViewer;
    private  PinkView pinkViewer;
    private  OrangeView orangeViewer;
    private  CyanView cyanViewer;
    private GameModel gameModel;

    private void create(){
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

    public GameView(GameModel gameModel, Screen screen) throws IOException {
        super(gameModel, screen);
        this.gameModel=gameModel;
        create();
    }

    public GameView(GameModel gameModel, Screen screen, TextGraphics graphics) throws IOException {
        super(gameModel, screen);
        this.gameModel=gameModel;
        this.graphics=graphics;
        create();
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