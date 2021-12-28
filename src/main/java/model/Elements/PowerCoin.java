package model.Elements;

import model.Position;

public class PowerCoin extends Coins{
    public final static int PowerCoinValue = 200;

    public PowerCoin(Position position) {
        super(position);
    }

    @Override
    public Collider getCollider() {
        return new Collider(new Position(position.getRow(), position.getCol()), 34, 14);
    }

    @Override
    public void update(long deltatime) {

    }
}
