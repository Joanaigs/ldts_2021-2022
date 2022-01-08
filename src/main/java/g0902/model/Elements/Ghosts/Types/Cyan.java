package g0902.model.Elements.Ghosts.Types;

import g0902.model.Elements.Ghosts.Ghost;
import g0902.model.Elements.Ghosts.MoveMode.ChaseMode.TargetStrategys.PatrolTargetStrategy;
import g0902.model.Elements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.TargetChaseStrategy;
import g0902.model.Elements.Ghosts.MoveMode.ScatterMode.ScatterBottomRight;
import g0902.model.Elements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import g0902.model.Maps.Map;
import g0902.model.Position;


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
