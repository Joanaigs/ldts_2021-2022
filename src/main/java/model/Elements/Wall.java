package model.Elements;

import model.Position;

import java.util.Objects;

public class Wall extends Element{

    private int width, height;

    public Wall(Position position, int width, int height) {
        super(position);
        this.width = width;
        this.height = height;
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
