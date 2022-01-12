package g0902.model.Elements.Coins;

import g0902.model.Elements.Collider;
import g0902.model.Elements.Element;
import g0902.model.Position;

public abstract class Coin extends Element {

    public Coin(Position position) {
        super(position);
    }

    public abstract Collider getCollider();

    @Override
    public boolean equals(Object obj) {
        if (this.position == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coin coin = (Coin) obj;
        return coin.getPosition().equals(position);
    }

}
