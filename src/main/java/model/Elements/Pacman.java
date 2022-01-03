package model.Elements;

import model.Position;

public class Pacman extends Element{
    private int highscore;
    private Direction nextDirection;
    private Direction currentDirection;
    private final double velocity = 50;
    private boolean mouthOpen;
    private boolean colliding;

    public Pacman(Position position) {
        super(position);
        highscore = 0;
        currentDirection = Direction.Down;
        nextDirection = Direction.None;
        mouthOpen = true;
    }
    // +5, -2, 26, 11

    @Override
    public Collider getCollider() {
        return new Collider(new Position(position.getRow(), position.getCol()), 34, 15);
    }
    // 32, 14
    public Direction moveUp() {return Direction.Up;}

    public Direction moveDown() {return Direction.Down;}

    public Direction moveLeft() {return Direction.Left;}

    public Direction moveRight() {return Direction.Right;}

    public void setDirection(Direction direction){ this.nextDirection = direction;}

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }


    public Position move(long deltatime, Direction direction){
        switch(direction){
            case Up:
                return new Position(position.getRow()- (int)(velocity*deltatime/1000), position.getCol());
            case Down:
                return new Position(position.getRow()+ (int)(velocity*deltatime/1000), position.getCol());
            case Left:
                return new Position(position.getRow(), position.getCol() - (int)(velocity*deltatime/1000*2));
            case Right:
                return new Position(position.getRow(), position.getCol() + (int)(velocity*deltatime/1000*2));
        }
        return new Position(position.getRow(), position.getCol());
    }

    public Position moveNextDirection(long deltatime){
        return move(deltatime, nextDirection);
    }

    public Position moveCurrentDirection(long deltatime){
        return move(deltatime, currentDirection);
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public Direction getNextDirection() {
        return nextDirection;
    }

    public void nextDirection(){
        currentDirection = nextDirection;
    }

    public boolean isOpen(){
        return mouthOpen;
    }

    @Override
    public void update(long deltatime) {

    }

    public void increaseScore(int score){
        highscore += score;
    }

    public int getScore(){
        return highscore;
    }
}
