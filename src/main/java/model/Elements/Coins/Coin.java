package model.Elements.Coins;

import model.Elements.Collider;
import model.Elements.Element;
import model.Elements.Wall;
import model.Position;

public abstract class Coin extends Element {

    public Coin(Position position) {
        super(position);
    }

    public abstract Collider getCollider();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coin coin = (Coin) obj;
        return coin.getPosition().equals(position);
    }

}
