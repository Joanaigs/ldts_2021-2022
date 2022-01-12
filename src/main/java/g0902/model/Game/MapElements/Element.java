package g0902.model.Game.MapElements;

import g0902.view.ElementsView.Collider;
import g0902.model.Position;

public abstract class Element {

    protected Position position;

    public Element(Position position) {
        this.position = position;
    }

    public Position getPosition(){ return position;};

    public void setPosition(Position position){ this.position=position;}

    public abstract Collider getCollider();


}
