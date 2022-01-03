package model.Elements.Ghosts.Types;

import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Moves.FrightenedMode.FrightenedMode;
import model.Elements.Ghosts.Moves.ChaseMode.TargetStrategys.AmbushTargetStrategy;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseStrategys.TargetChaseStrategy;
import model.Elements.Ghosts.Moves.ScatterMode.ScatterTopLeft;
import model.Maps.Map;
import model.Position;

public class Pink extends Ghost {

    public Pink(Position position) {
        super(position);
        setChaseStrategy(new TargetChaseStrategy(new AmbushTargetStrategy(), this));
        setFrightenedBehaviour(new FrightenedMode(this));
        setScatterBehaviour(new ScatterTopLeft(this));
    }

    public void setMap(Map map){
        ((TargetChaseStrategy)getChaseStrategy()).setMap(map);
        ((ScatterTopLeft)getScatterBehaviour()).setMap(map);
        ((FrightenedMode) getFrightenedBehaviour()).setMap(map);
    }

}
