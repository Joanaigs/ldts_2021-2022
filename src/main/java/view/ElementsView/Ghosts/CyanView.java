package view.ElementsView.Ghosts;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.Elements.Coins.PowerCoin;
import model.Elements.Coins.SmallCoin;
import model.Elements.Ghosts.Cyan;
import model.Elements.Ghosts.Ghost;
import model.Elements.Wall;
import model.GameModel;
import view.ElementsView.Coins.PowerCoinView;
import view.ElementsView.Coins.SmallCoinView;
import view.ElementsView.PacmanView;
import view.ElementsView.View;
import view.ElementsView.WallView;
import view.Viewer;

import java.io.IOException;

public class CyanView extends View {
    private Cyan cyan;

    public static final String[] normalGhost= {
            "     ####",
            "   ########",
            "  #00####00#",
            " #0000##0000#",
            " #0110##0110#",
            " #0110##0110#",
            "##0110##0110##",
            "###00####00###",
            "##############",
            "##############",
            "## ###  ### ##",
            "#   ##  ##   #",
    };

    public CyanView(Ghost cyan, TextGraphics graphics) {
        super(graphics);
        this.cyan = (Cyan) cyan;
    }

    @Override
    public void draw() {
        int y = 0;
        for (String s : normalGhost ){
            for (int x = 0; x < s.length(); x++){
                switch(s.charAt(x)){
                    case '#' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#00FFFF"));
                    case '0' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
                    case '1' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#2121DE"));
                    default  ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));

                }

                graphics.fillRectangle(new TerminalPosition(
                                cyan.getPosition().getCol() + x *2 + 1 , cyan.getPosition().getRow() + y -2),
                        new TerminalSize(2, 1), ' ');
            }
            y++;
        }
    }


    public static class GameView extends Viewer<GameModel> {
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
}
