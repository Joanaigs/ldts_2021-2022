package model.Elements;

import model.Position;

public abstract class Coins extends Element{

    public Coins(Position position) {
        super(position);
    }

    public abstract Collider getCollider();
}
