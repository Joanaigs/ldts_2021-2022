package g0902.model.Game.MapElements;
import g0902.view.ElementsView.Constants;
import g0902.view.ElementsView.Collider;
import g0902.model.Direction;
import g0902.model.Game.Map.Map;
import g0902.model.Position;

public class Pacman extends Element{
    private int highscore;
    private Map map;
    private Direction nextDirection;
    private Direction currentDirection;
    private final double velocity = 50;
    private boolean mouthOpen;
    private final Position beginPosition;
    private final static int width = 34;
    private final static int height = 15;

    public Pacman(Position position) {
        super(position);
        highscore = 0;
        currentDirection = Direction.Down;
        nextDirection = Direction.None;
        mouthOpen = true;
        beginPosition=position;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public Collider getCollider() {
        return new Collider(new Position(position.getRow(), position.getCol()), width, height);
    }

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

    public void increaseScore(int score){
        highscore += score;
    }

    public int getScore(){
        return highscore;
    }

    public Position getBeginPosition() {
        return beginPosition;
    }


    boolean collideWithWalls(Collider collider) {
        for (Wall wall : map.getWalls()) {
            if (wall.getCollider().collision(collider))
                return true;
        }
        return false;
    }


    public final void fixPassScreenBorder(){
        if(getPosition().getCol() > map.getWidth())
            getPosition().setCol(-width);
        else if(getPosition().getCol() < -width)
            getPosition().setCol(map.getWidth());
    }


    public void update(long deltatime){
        Position oldPosition = new Position(getPosition().getRow(), getPosition().getCol());

        Position next = moveNextDirection(deltatime);
        if (collideWithWalls(new Collider(next, getCollider().getWidth(), getCollider().getHeight()))) {
            next = moveCurrentDirection(deltatime);

            if (collideWithWalls(new Collider(next, getCollider().getWidth(), getCollider().getHeight()))) {
                setPosition(oldPosition);
                setDirection(Direction.None);
            } else {
                setPosition(next);
            }
        } else {
            if (getNextDirection() != getCurrentDirection()) {
                int row = (int) Math.round(next.getRow() / 8.0);
                int col = (int) Math.round(next.getCol() / 12.0);

                switch (getNextDirection()) {
                    case Up, Down -> next.setCol(col * 12 + 1);
                    case Left,Right -> next.setRow(row * 8 + 1);
                }
            }
            setPosition(next);
            nextDirection();
        }
        fixPassScreenBorder();
    }

}