package g0902.model.Game.MapElements.Coins;

import g0902.view.ElementsView.Collider;
import g0902.model.Position;


public class SmallCoin extends Coin {
    public final static int SmallCoinValue = 10;
    private final static int width = 10;
    private final static int height = 5;

    public SmallCoin(Position position) {
        super(position, width, height);
    }

}
