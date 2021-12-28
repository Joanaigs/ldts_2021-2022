package model.Elements;

import model.Position;


public class SmallCoin extends Coins{
    public final static int SmallCoinValue = 10;

    public SmallCoin(Position position) {
        super(position);
    }

    @Override
    public void update(long deltatime) {

    }

    @Override
    public Collider getCollider() {
        return new Collider(new Position(position.getRow(), position.getCol()), 34, 14);
    }

}
