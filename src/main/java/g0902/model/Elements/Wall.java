package g0902.model.Elements;

import g0902.model.Position;

public class Wall extends Element{

    private int width, height;
    private Collider collider;

    public Wall(Position position, int width, int height) {
        super(position);
        this.width = width;
        this.height = height;
        collider = new Collider(new Position(position.getRow(), position.getCol()), 13, 9);
    }

    @Override
    public Collider getCollider() {
        return collider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return width == wall.width && height == wall.height &&  wall.getPosition().equals(position);
    }

    public int getWidth() { return width;}

    public int getHeight() { return height;}

}
