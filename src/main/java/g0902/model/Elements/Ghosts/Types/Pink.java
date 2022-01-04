package g0902.model.Elements.Ghosts.Types;

import g0902.model.Elements.Ghosts.Ghost;
import g0902.model.Elements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import g0902.model.Elements.Ghosts.MoveMode.ChaseMode.TargetStrategys.AmbushTargetStrategy;
import g0902.model.Elements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.TargetChaseStrategy;
import g0902.model.Elements.Ghosts.MoveMode.ScatterMode.ScatterTopLeft;
import g0902.model.Maps.Map;
import g0902.model.Position;

public class Pink extends Ghost {

    public Pink(Position position) {
        super(position);
        setChaseStrategy(new TargetChaseStrategy(new AmbushTargetStrategy(), this));
        setFrightenedBehaviour(new FrightenedMode(this));
        setScatterBehaviour(new ScatterTopLeft(this));
    }

    public void setMap(Map map){
        ((TargetChaseStrategy)getChaseStrategy()).setMap(map);
        (getScatterBehaviour()).setMap(map);
        ((FrightenedMode) getFrightenedBehaviour()).setMap(map);
    }

}
