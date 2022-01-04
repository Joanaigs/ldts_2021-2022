package g0902.model.Elements.Coins;

import g0902.model.Elements.Collider;
import g0902.model.Position;

public class PowerCoin extends Coin {
    public final static int PowerCoinValue = 200;

    public PowerCoin(Position position) {
        super(position);
    }

    @Override
    public Collider getCollider() {
        return new Collider(new Position(position.getRow(), position.getCol()), 15, 6);
    }

    @Override
    public void update(long deltatime) {

    }

}
