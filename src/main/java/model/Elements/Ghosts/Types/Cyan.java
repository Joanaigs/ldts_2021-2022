package model.Elements.Ghosts.Types;

import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.MoveMode.ChaseMode.TargetStrategys.PatrolTargetStrategy;
import model.Elements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.TargetChaseStrategy;
import model.Elements.Ghosts.MoveMode.ScatterMode.ScatterBottomRight;
import model.Elements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import model.Maps.Map;
import model.Position;


public class Cyan extends Ghost {

    public Cyan(Position position) {
        super(position);
        setChaseStrategy(new TargetChaseStrategy(new PatrolTargetStrategy(), this));
        setFrightenedBehaviour(new FrightenedMode(this));
        setScatterBehaviour(new ScatterBottomRight(this));
    }

    public void setMap(Map map){
        ((TargetChaseStrategy)getChaseStrategy()).setMap(map);
        (getScatterBehaviour()).setMap(map);
        ((FrightenedMode) getFrightenedBehaviour()).setMap(map);
    }
}
