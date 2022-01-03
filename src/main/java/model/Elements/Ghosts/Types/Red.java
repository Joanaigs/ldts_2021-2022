package model.Elements.Ghosts.Types;

import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import model.Elements.Ghosts.MoveMode.ChaseMode.TargetStrategys.AggressiveTargetStrategy;
import model.Elements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.TargetChaseStrategy;
import model.Elements.Ghosts.MoveMode.ScatterMode.ScatterTopRight;
import model.Maps.Map;
import model.Position;

public class Red extends Ghost {

    public Red(Position position) {
        super(position);
        setChaseStrategy(new TargetChaseStrategy(new AggressiveTargetStrategy(), this));
        setScatterBehaviour(new ScatterTopRight(this));
        setFrightenedBehaviour(new FrightenedMode(this));
    }

    public void setMap(Map map){
        ((TargetChaseStrategy)getChaseStrategy()).setMap(map);
        (getScatterBehaviour()).setMap(map);
        ((FrightenedMode) getFrightenedBehaviour()).setMap(map);
    }

}
