package model.Elements.Ghosts;

import model.Elements.*;
import model.Elements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.ChaseStrategy;
import model.Elements.Ghosts.MoveMode.FrightenedMode.FrightenedBehaviour;
import model.Elements.Ghosts.MoveMode.ScatterMode.ScatterBehaviour;
import model.Maps.Map;
import model.Position;

public class Ghost extends Element {
    private final double velocity = 55;
    ChaseStrategy chaseStrategy;
    FrightenedBehaviour frightenedBehaviour;
    private boolean frightenedModeOn;
    private Direction currentDirection;
    ScatterBehaviour scatterBehaviour;
    protected long counterTime;
    protected long frightenedTime;

    public Ghost(Position position) {
        super(position);
        currentDirection = Direction.None;
        frightenedModeOn = false;
        counterTime = 0;
    }

    @Override
    public void update(long deltatime) {
        if(frightenedTime > 9000)
            frightenedModeOn = false;


        if(!frightenedModeOn) {
            counterTime += deltatime;

            if( counterTime > 20000)     // the time is on ms
                counterTime -= 20000;

            if (counterTime < 7000)
                setCurrentDirection(getScatterBehaviour().Scatter(deltatime));
            else
                setCurrentDirection(getChaseStrategy().chase(deltatime));
        }
        else {
            setCurrentDirection(getFrightenedBehaviour().frightened(deltatime));
            frightenedTime += deltatime;
        }


        setPosition(move(deltatime, getCurrentDirection()));

    }

    public long getFrightenedTime() {
        return frightenedTime;
    }

    @Override
    public Collider getCollider() {
        return new Collider(new Position(position.getRow(), position.getCol()), 35, 15);
    }

    public void setFrightenedModeOn(){
        frightenedModeOn= true;
        frightenedTime = 0;
    }


    // anda na direção dada, mudando de posição
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


    public ChaseStrategy getChaseStrategy() {
        return chaseStrategy;
    }

    public boolean collideWithWall(Map map)
    {
        for( Wall wall: map.getWalls())
            if(getCollider().colision(wall.getCollider()))
                return true;
        return false;
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

    public void setScatterBehaviour(ScatterBehaviour scatterBehaviour) {
        this.scatterBehaviour = scatterBehaviour;
    }
}
