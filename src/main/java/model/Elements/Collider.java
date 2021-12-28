package model.Elements;

import model.Position;

import java.awt.*;

public class Collider{
    Rectangle collider;

    public Collider(Position position,int width, int height){
        collider = new Rectangle(position.getCol(), position.getRow(), width, height);
    }

    public Rectangle getRectangle() {
        return collider;
    }

    public boolean colision(Collider collider) {
        return this.collider.intersects(collider.getRectangle());
    }

    public int getWidth(){ return (int)collider.getWidth();}

    public int getHeight(){ return (int)collider.getHeight();}
}

