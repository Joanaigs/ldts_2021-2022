package g0902.model.Game.MapElements.Ghosts.Types;

import g0902.model.Game.MapElements.Ghosts.Ghost;
import g0902.model.Game.MapElements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import g0902.model.Game.MapElements.Ghosts.MoveMode.ChaseMode.TargetStrategys.AmbushTargetStrategy;
import g0902.model.Game.MapElements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.TargetChaseStrategy;
import g0902.model.Game.MapElements.Ghosts.MoveMode.ScatterMode.ScatterTopLeft;
import g0902.model.Game.Map.Map;
import g0902.model.Position;

public class Pink extends Ghost {

    public Pink(Position position) {
        super(position);
        setChaseStrategy(new TargetChaseStrategy(new AmbushTargetStrategy(), this));
        setFrightenedBehaviour(new FrightenedMode(this));
        setScatterBehaviour(new ScatterTopLeft(this));
    }

}
