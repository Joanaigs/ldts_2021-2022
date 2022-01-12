package g0902.model.Game.MapElements.Ghosts.Types;

import g0902.model.Game.MapElements.Ghosts.Ghost;
import g0902.model.Game.MapElements.Ghosts.MoveMode.ChaseMode.TargetStrategys.PatrolTargetStrategy;
import g0902.model.Game.MapElements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.TargetChaseStrategy;
import g0902.model.Game.MapElements.Ghosts.MoveMode.ScatterMode.ScatterBottomRight;
import g0902.model.Game.MapElements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import g0902.model.Game.Map.Map;
import g0902.model.Position;


public class Cyan extends Ghost {

    public Cyan(Position position) {
        super(position);
        setChaseStrategy(new TargetChaseStrategy(new PatrolTargetStrategy(), this));
        setFrightenedBehaviour(new FrightenedMode(this));
        setScatterBehaviour(new ScatterBottomRight(this));
    }

}
