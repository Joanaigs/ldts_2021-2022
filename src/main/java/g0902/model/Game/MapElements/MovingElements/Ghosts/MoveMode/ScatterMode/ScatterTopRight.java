package g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ScatterMode;

import g0902.model.Game.MapElements.MovingElements.Ghosts.Ghost;
import g0902.model.Position;

import java.util.List;

public class ScatterTopRight extends ScatterBehaviour {

    public ScatterTopRight(Ghost ghost) {
        super(ghost, List.of(new Position(5*8, 31*12),
                new Position(8, 31*12),
                new Position(8, 37*12),
                new Position(5*8, 37*12)));

    }

}
