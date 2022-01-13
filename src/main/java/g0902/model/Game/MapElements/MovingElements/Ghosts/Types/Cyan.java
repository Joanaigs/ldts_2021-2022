package g0902.model.Game.MapElements.MovingElements.Ghosts.Types;

import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.TargetChaseStrategy;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Ghost;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseMode.TargetStrategys.PatrolTargetStrategy;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ScatterMode.ScatterBottomRight;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import g0902.model.Position;


public class Cyan extends Ghost {

    public Cyan(Position position) {
        super(position);
        setChaseStrategy(new TargetChaseStrategy(new PatrolTargetStrategy(), this));
        setFrightenedBehaviour(new FrightenedMode(this));
        setScatterBehaviour(new ScatterBottomRight(this));
    }

}
