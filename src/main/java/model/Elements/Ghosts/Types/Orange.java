package model.Elements.Ghosts.Types;

import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import model.Elements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.RandomChaseStrategy;
import model.Elements.Ghosts.MoveMode.ScatterMode.ScatterBottomLeft;
import model.Maps.Map;
import model.Position;

public class Orange  extends Ghost {

    public Orange(Position position) {
        super(position);
        setChaseStrategy(new RandomChaseStrategy(this));
        setScatterBehaviour(new ScatterBottomLeft(this));
        setFrightenedBehaviour(new FrightenedMode(this));
    }

    public void setMap(Map map){
        ((RandomChaseStrategy)getChaseStrategy()).setMap(map);
        (getScatterBehaviour()).setMap(map);
        ((FrightenedMode) getFrightenedBehaviour()).setMap(map);
    }

}
