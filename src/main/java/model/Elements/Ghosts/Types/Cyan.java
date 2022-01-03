package model.Elements.Ghosts.Types;

import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Moves.ChaseMode.TargetStrategys.PatrolTargetStrategy;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseStrategys.TargetChaseStrategy;
import model.Elements.Ghosts.Moves.ScatterMode.ScatterBottomRight;
import model.Elements.Ghosts.Moves.FrightenedMode.FrightenedMode;
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
        ((ScatterBottomRight)getScatterBehaviour()).setMap(map);
        ((FrightenedMode) getFrightenedBehaviour()).setMap(map);
    }
}
