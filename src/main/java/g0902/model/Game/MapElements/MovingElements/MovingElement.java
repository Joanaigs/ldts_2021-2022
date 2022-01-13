package g0902.model.Game.MapElements.MovingElements;

import g0902.Constants;
import g0902.model.Direction;
import g0902.model.Game.Map.Map;
import g0902.model.Game.MapElements.Element;
import g0902.model.Game.MapElements.Wall;
import g0902.model.Position;
import g0902.view.ElementsView.Collider;

public class MovingElement extends Element {
    private Map map;
    private Direction currentDirection;
    private Position beginPosition;
    private double velocityX, velocityY;


    public MovingElement(Position position, int width, int height) {
        super(position, width, height);
        setVelocity(0.0, 0.0);
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Map getMap() {return map;}

    public void setVelocity(double velocityX, double velocityY) {this.velocityX = velocityX; this.velocityY = velocityY;}

    public Direction getCurrentDirection() {return currentDirection;}

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public boolean collideWithWall(Collider collider) {
        for (Wall wall : map.getWalls()) {
            if (wall.getCollider().collision(collider))
                return true;
        }
        return false;
    }

    public void setBeginPositionPosition(Position position) {beginPosition = position;}

    public Position getBeginPosition() {return beginPosition;}

    public final void fixPassScreenBorder(){
        if(getPosition().getCol() > Constants.SCREEN_WIDTH-1)
            getPosition().setCol(-getWidth());
        else if(getPosition().getCol() < -getWidth()+1)
            getPosition().setCol(Constants.SCREEN_WIDTH);
    }

    public Position move(long deltatime, Direction direction){
        switch(direction){
            case Up:
                return new Position(position.getRow()- (int)(velocityY*deltatime/1000), position.getCol());
            case Down:
                return new Position(position.getRow()+ (int)(velocityY*deltatime/1000), position.getCol());
            case Left:
                return new Position(position.getRow(), position.getCol() - (int)(velocityX*deltatime/1000));
            case Right:
                return new Position(position.getRow(), position.getCol() + (int)(velocityX*deltatime/1000));
        }
        return new Position(position.getRow(), position.getCol());
    }

}
