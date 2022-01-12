package g0902.model.Game.MapElements.Coins;

import g0902.view.ElementsView.Collider;
import g0902.model.Position;


public class SmallCoin extends Coin {
    public final static int SmallCoinValue = 10;

    public SmallCoin(Position position) {
        super(position);
    }

    @Override
    public Collider getCollider() {
        return new Collider(new Position(position.getRow(), position.getCol()), 10, 5);
    }


}
