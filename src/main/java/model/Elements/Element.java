package model.Elements;

import model.Position;

public abstract class Element {

    protected Position position;

    public Element(Position position) {
        this.position = position;
    }

    public Position getPosition(){ return position;};

    public void setPosition(Position position){ this.position=position;}

    public abstract void update(long deltatime);

    public abstract Collider getCollider();

}
