package g0902.model.Game.MapElements.Ghosts.Types;

import g0902.model.Game.MapElements.Ghosts.Ghost;
import g0902.model.Game.MapElements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import g0902.model.Game.MapElements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.RandomChaseStrategy;
import g0902.model.Game.MapElements.Ghosts.MoveMode.ScatterMode.ScatterBottomLeft;
import g0902.model.Game.Map.Map;
import g0902.model.Position;

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
