package model.Elements.Ghosts;

import model.Elements.Collider;
import model.Elements.Element;
import model.Position;

public class Ghost extends Element {

    public Ghost(Position position) {
        super(position);
    }

    @Override
    public void update(long deltatime) {

    }

    @Override
    public Collider getCollider() {
        return null;
    }
}
