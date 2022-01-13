package g0902.model.Game.MapElements;

import g0902.view.ElementsView.Collider;
import g0902.model.Position;

public class Wall extends Element{

    public Wall(Position position, int width, int height) {
        super(position, width, height);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return getWidth() == wall.getWidth() && getHeight() == wall.getHeight() &&  wall.getPosition().equals(position);
    }

}
