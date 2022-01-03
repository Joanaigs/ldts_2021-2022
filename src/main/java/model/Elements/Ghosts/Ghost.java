package model.Elements.Ghosts;

import model.Elements.*;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseStrategys.ChaseStrategy;
import model.Elements.Ghosts.Moves.FrightenedMode.FrightenedBehaviour;
import model.Elements.Ghosts.Moves.ScatterMode.ScatterBehaviour;
import model.Maps.Map;
import model.Position;

public class Ghost extends Element {
    private final double velocity = 60;
    ChaseStrategy chaseStrategy;
    FrightenedBehaviour frightenedBehaviour;
    private boolean frightenedModeOn;
    private Direction currentDirection;
    ScatterBehaviour scatterBehaviour;

    public Ghost(Position position) {
        super(position);
        currentDirection = Direction.None;
        frightenedModeOn = false;
    }

    @Override
    public void update(long deltatime) {

        if(!frightenedModeOn) {
            if(getChaseStrategy() != null) {
                setCurrentDirection(getChaseStrategy().chase(deltatime));
                setPosition(move(deltatime, getCurrentDirection()));
                //setCurrentDirection(getScatterBehaviour().Scatter(deltatime));
                //setPosition(move(deltatime, getCurrentDirection()));
            }
        }

        else {
            setCurrentDirection(getFrightenedBehaviour().frightened(deltatime));
            setPosition(move(deltatime, getCurrentDirection()));
        }

        // contador e
        // move(deltatime, ScatterBehaviour.chase());

    }



    @Override
    public Collider getCollider() {
        return new Collider(new Position(position.getRow(), position.getCol()), 35, 15);
    }

    public void setFrightenedModeOn(){
        frightenedModeOn= true;
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
