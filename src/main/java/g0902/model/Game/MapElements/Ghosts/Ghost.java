package g0902.model.Game.MapElements.Ghosts;

import g0902.view.ElementsView.Collider;
import g0902.model.Direction;
import g0902.model.Game.MapElements.*;
import g0902.model.Game.MapElements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.ChaseStrategy;
import g0902.model.Game.MapElements.Ghosts.MoveMode.FrightenedMode.FrightenedBehaviour;
import g0902.model.Game.MapElements.Ghosts.MoveMode.ScatterMode.ScatterBehaviour;
import g0902.model.Game.Map.Map;
import g0902.model.Position;

public class Ghost extends Element {
    private final double velocity = 50;
    ChaseStrategy chaseStrategy;
    FrightenedBehaviour frightenedBehaviour;
    private boolean frightenedModeOn;
    private Direction currentDirection;
    ScatterBehaviour scatterBehaviour;
    protected long counterTime;
    protected long frightenedTime;
    Position beginPosition;
    Map map;
    private final static int width = 34;
    private final static int height = 15;
    int score;

    public Ghost(Position position) {
        super(position);
        currentDirection = Direction.None;
        frightenedModeOn = false;
        counterTime = 0;
        beginPosition = position;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Map getMap() {return map;}

    public void update(long deltatime) {
        if(frightenedTime > 9000)
            frightenedModeOn = false;
        if(!frightenedModeOn) {
            counterTime += deltatime;
            if( counterTime > 20000)  counterTime -= 20000;
            if (counterTime < 7000) setCurrentDirection(getScatterBehaviour().Scatter(deltatime));
            else setCurrentDirection(getChaseStrategy().chase(deltatime));
        }
        else {
            setCurrentDirection(getFrightenedBehaviour().frightened(deltatime));
            frightenedTime += deltatime;
        }
        setPosition(move(deltatime, getCurrentDirection()));
        fixPassScreenBorder();
    }

    public final void fixPassScreenBorder(){
        if(getPosition().getCol() > map.getWidth())
            getPosition().setCol(-width);
        else if(getPosition().getCol() < -width)
            getPosition().setCol(map.getWidth());
    }

    public void setFrightenedModeOn(){
        frightenedModeOn= true;
        frightenedTime = 0;
        score=200;
    }

    public void setFrightenedModeOff(){
        frightenedModeOn= false;
    }

    public Position move(long deltatime, Direction direction){
        return switch (direction) {
            case Up -> new Position(position.getRow() - (int) (velocity * deltatime / 1000), position.getCol());
            case Down -> new Position(position.getRow() + (int) (velocity * deltatime / 1000), position.getCol());
            case Left -> new Position(position.getRow(), position.getCol() - (int) (velocity * deltatime / 1000 * 1.8));
            case Right -> new Position(position.getRow(), position.getCol() + (int) (velocity * deltatime / 1000 * 1.8));
            default -> new Position(position.getRow(), position.getCol());
        };
    }

    public boolean collideWithWall(Map map)
    {
        for( Wall wall: map.getWalls())
            if(getCollider().collision(wall.getCollider()))
                return true;
        return false;
    }

    public long getFrightenedTime() {return frightenedTime;}

    @Override
    public Collider getCollider() {
        return new Collider(new Position(position.getRow(), position.getCol()), 35, 15);
    }

    public ChaseStrategy getChaseStrategy() {
        return chaseStrategy;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void setChaseStrategy(ChaseStrategy chaseStrategy) {
        this.chaseStrategy = chaseStrategy;
    }

    public void setFrightenedBehaviour(FrightenedBehaviour frightenedBehaviour) { this.frightenedBehaviour = frightenedBehaviour; }

    public FrightenedBehaviour getFrightenedBehaviour() {
        return frightenedBehaviour;
    }

    public boolean getFrightenedModeOn() {
        return frightenedModeOn;
    }

    public ScatterBehaviour getScatterBehaviour() {
        return scatterBehaviour;
    }

    public void setScatterBehaviour(ScatterBehaviour scatterBehaviour) {this.scatterBehaviour = scatterBehaviour;}

    public void updateScore() {
        score+=200;
    }

    public int getScore() {
        return score;
    }

    public Position getBeginPosition() {
        return beginPosition;
    }
}