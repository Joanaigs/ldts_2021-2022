package g0902.model.Game.MapElements;

import g0902.model.Collider;
import g0902.model.Position;

public abstract class Element {
    private final int width;
    private final int height;

    protected Position position;
    public Element(Position position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height =height;
    }

    public Position getPosition(){ return position;}

    public void setPosition(Position position){ this.position=position;}

    public final Collider getCollider() {return new Collider(new Position(position.getRow(), position.getCol()), width, height);}

    public int getWidth() {return width;}

    public int getHeight() {return height;}


}
