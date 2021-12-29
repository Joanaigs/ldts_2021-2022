package model.Elements.Coins;

import model.Elements.Collider;
import model.Elements.Element;
import model.Position;

public abstract class Coin extends Element {

    public Coin(Position position) {
        super(position);
    }

    public abstract Collider getCollider();
}
