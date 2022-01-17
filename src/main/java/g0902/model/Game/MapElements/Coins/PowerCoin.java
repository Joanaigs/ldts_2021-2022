package g0902.model.Game.MapElements.Coins;

import g0902.model.Position;

public class PowerCoin extends Coin {
    public final static int PowerCoinValue = 200;
    private final static int width = 15;
    private final static int height = 6;

    public PowerCoin(Position position) {
        super(position, width, height);
    }


}
