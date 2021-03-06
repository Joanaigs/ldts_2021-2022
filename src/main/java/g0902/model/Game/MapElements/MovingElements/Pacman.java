package g0902.model.Game.MapElements.MovingElements;
import g0902.model.Collider;
import g0902.model.Direction;
import g0902.model.Position;

public class Pacman extends MovingElement {
    private int score;
    private Direction nextDirection;
    private boolean mouthOpen;
    private final static int width = 34;
    private final static int height = 15;
    int lives;

    public Pacman(Position position) {
        super(position, width, height);
        score = 0;
        setCurrentDirection(Direction.Down);
        setBeginPositionPosition(position);
        setVelocity(55*2, 55);
        nextDirection = Direction.None;
        mouthOpen = true;
        lives = 3;
    }

    @SuppressWarnings("MissingCasesInEnumSwitch")
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
                    case Up, Down -> next.setCol(col * 12 + 1);
                    case Left, Right -> next.setRow(row * 8 + 1);
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

    public void increaseScore(int valueEaten){
        score += valueEaten;
    }

    public int getScore(){return score;}

    public int getLives() {return lives;}

    public void decreaseLives(){ lives--;}

    public void setMouthOpen(boolean mouthOpen) {
        this.mouthOpen = mouthOpen;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setScore(int score) {this.score = score;}
}