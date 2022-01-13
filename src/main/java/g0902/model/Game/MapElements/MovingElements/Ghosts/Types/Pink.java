package g0902.model.Game.MapElements.MovingElements.Ghosts.Types;

import g0902.model.Game.MapElements.MovingElements.Ghosts.Ghost;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.TargetChaseStrategy;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseMode.TargetStrategys.AmbushTargetStrategy;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ScatterMode.ScatterTopLeft;
import g0902.model.Position;

public class Pink extends Ghost {

    public Pink(Position position) {
        super(position);
        setChaseStrategy(new TargetChaseStrategy(new AmbushTargetStrategy(), this));
        setFrightenedBehaviour(new FrightenedMode(this));
        setScatterBehaviour(new ScatterTopLeft(this));
    }

}
