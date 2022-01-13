package g0902.model.Game.MapElements.MovingElements.Ghosts;

import g0902.model.Direction;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.ChaseStrategy;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.FrightenedMode.FrightenedBehaviour;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ScatterMode.ScatterBehaviour;
import g0902.model.Position;

public class Ghost extends MovingElement {
    ChaseStrategy chaseStrategy;
    FrightenedBehaviour frightenedBehaviour;
    private boolean frightenedModeOn;
    ScatterBehaviour scatterBehaviour;
    protected long counterTime;
    protected long frightenedTime;
    private final static int width = 35;
    private final static int height = 15;
    int ghostValue;

    public Ghost(Position position) {
        super(position, width, height);
        setCurrentDirection(Direction.None);
        setBeginPositionPosition(position);
        setVelocity(50*1.8, 50);
        frightenedModeOn = false;
        counterTime = 0;
    }

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

    public void updateGhostValue() {ghostValue +=200;}

    public int getGhostValue() {return ghostValue;}


    // Related with Mode Moves of ghosts.

    public long getFrightenedTime() {return frightenedTime;}

    public FrightenedBehaviour getFrightenedBehaviour() {return frightenedBehaviour;}

    public void setFrightenedBehaviour(FrightenedBehaviour frightenedBehaviour) { this.frightenedBehaviour = frightenedBehaviour; }

    public boolean getFrightenedModeOn() {return frightenedModeOn;}

    public void setFrightenedModeOn(){
        frightenedModeOn= true;
        frightenedTime = 0;
        ghostValue =200;
    }

    public void setFrightenedModeOff(){frightenedModeOn= false;}

    public ChaseStrategy getChaseStrategy() {return chaseStrategy;}

    public void setChaseStrategy(ChaseStrategy chaseStrategy) {this.chaseStrategy = chaseStrategy;}

    public ScatterBehaviour getScatterBehaviour() {return scatterBehaviour;}

    public void setScatterBehaviour(ScatterBehaviour scatterBehaviour) {this.scatterBehaviour = scatterBehaviour;}

}