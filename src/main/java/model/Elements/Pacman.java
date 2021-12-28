package model.Elements;

import model.Position;

public class Pacman extends Element{
    private int highscore;
    private Direction nextDirection;
    private Direction currentDirection;
    private final double velocity = 62/3;
    private boolean mouthOpen;

    public Pacman(Position position) {
        super(position);
        highscore = 0;
        currentDirection = Direction.None;
        nextDirection = Direction.None;
        mouthOpen = true;
    }


    public Direction moveUp() {return Direction.Up;}

    public Direction moveDown() {return Direction.Down;}

    public Direction moveLeft() {return Direction.Left;}

    public Direction moveRight() {return Direction.Right;}


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
                return new Position(position.getRow(), position.getCol() - (int)(velocity*deltatime/1000*12/8));
            case Right:
                return new Position(position.getRow(), position.getCol() + (int)(velocity*deltatime/1000*12/8));
        }
        return new Position(position.getRow(), position.getCol());
    }


    public boolean isOpen(){
        return mouthOpen;
    }

}
