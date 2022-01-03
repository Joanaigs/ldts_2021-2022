package model.Elements.Ghosts.Types;

import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Moves.FrightenedMode.FrightenedMode;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseStrategys.RandomChaseStrategy;
import model.Elements.Ghosts.Moves.ScatterMode.ScatterBottomLeft;
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
        ((ScatterBottomLeft)getScatterBehaviour()).setMap(map);
        ((FrightenedMode) getFrightenedBehaviour()).setMap(map);
    }

}
