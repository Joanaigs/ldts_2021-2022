package g0902.model.Game.MapElements.MovingElements.Ghosts.Types;

import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseMode.ChaseStrategys.RandomChaseStrategy;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Ghost;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.FrightenedMode.FrightenedMode;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ScatterMode.ScatterBottomLeft;
import g0902.model.Position;

public class Orange  extends Ghost {

    public Orange(Position position) {
        super(position);
        setChaseStrategy(new RandomChaseStrategy(this));
        setScatterBehaviour(new ScatterBottomLeft(this));
        setFrightenedBehaviour(new FrightenedMode(this));
    }

}
