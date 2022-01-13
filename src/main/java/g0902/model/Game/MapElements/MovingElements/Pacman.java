package g0902.model.Game.MapElements.MovingElements;
import g0902.view.ElementsView.Collider;
import g0902.model.Direction;
import g0902.model.Position;

public class Pacman extends MovingElement{
    private int highscore;
    private Direction nextDirection;
    private final boolean mouthOpen;
    private final static int width = 34;
    private final static int height = 15;

    public Pacman(Position position) {
        super(position, width, height);
        highscore = 0;
        setCurrentDirection(Direction.Down);
        setBeginPositionPosition(position);
        setVelocity(100, 50);
        nextDirection = Direction.None;
        mouthOpen = true;
    }

    public void update(long deltatime){
        Position oldPosition = new Position(getPosition().getRow(), getPosition().getCol());

        Position next = moveNextDirection(deltatime);
        if (collideWithWall(new Collider(next, getCollider().getWidth(), getCollider().getHeight()))) {
            next = moveCurrentDirection(deltatime);

            if (collideWithWall(new Collider(next, getCollider().getWidth(), getCollider().getHeight()))) {
                setPosition(oldPosition);
                setNextDirection(Direction.None);
            } else {
                setPosition(next);
            }
        } else {
            if (getNextDirection() != getCurrentDirection()) {
                int row = (int) Math.round(next.getRow() / 8.0);
                int col = (int) Math.round(next.getCol() / 12.0);

                switch (getNextDirection()) {
                    case Up:
                    case Down:
                        next.setCol(col * 12 + 1);
                        break;

                    case Left:
                    case Right:
                        next.setRow(row * 8 + 1);
                        break;
                }
            }
            setPosition(next);
            nextDirection();
        }
        fixPassScreenBorder();
    }


    public void setNextDirection(Direction direction){ this.nextDirection = direction;}

    public Position moveNextDirection(long deltatime){
        return move(deltatime, nextDirection);
    }

    public Position moveCurrentDirection(long deltatime){return move(deltatime, getCurrentDirection());}

    public Direction getNextDirection() {
        return nextDirection;
    }

    public void nextDirection(){setCurrentDirection(nextDirection);}

    public boolean isOpen(){
        return mouthOpen;
    }

    public void increaseScore(int score){
        highscore += score;
    }

    public int getScore(){
        return highscore;
    }

}