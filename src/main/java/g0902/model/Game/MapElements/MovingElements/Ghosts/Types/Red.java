package g0902.model.Game.MapElements.MovingElements.Ghosts.Types;

import g0902.model.Game.MapElements.MovingElements.Ghosts.Ghost;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.TargetChaseStrategy;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseMode.TargetStrategys.AggressiveTargetStrategy;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ScatterMode.ScatterTopRight;
import g0902.model.Position;

public class Red extends Ghost {

    public Red(Position position) {
        super(position);
        setChaseStrategy(new TargetChaseStrategy(new AggressiveTargetStrategy(), this));
        setScatterBehaviour(new ScatterTopRight(this));
        setFrightenedBehaviour(new FrightenedMode(this));
    }


}
