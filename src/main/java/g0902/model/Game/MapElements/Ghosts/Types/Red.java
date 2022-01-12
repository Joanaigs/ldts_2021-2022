package g0902.model.Game.MapElements.Ghosts.Types;

import g0902.model.Game.MapElements.Ghosts.Ghost;
import g0902.model.Game.MapElements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import g0902.model.Game.MapElements.Ghosts.MoveMode.ChaseMode.TargetStrategys.AggressiveTargetStrategy;
import g0902.model.Game.MapElements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.TargetChaseStrategy;
import g0902.model.Game.MapElements.Ghosts.MoveMode.ScatterMode.ScatterTopRight;
import g0902.model.Game.Map.Map;
import g0902.model.Position;

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
