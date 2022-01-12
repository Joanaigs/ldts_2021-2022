package g0902.model.Game.MapElements.Ghosts.MoveMode.ScatterMode;

import g0902.model.Game.MapElements.Ghosts.Ghost;
import g0902.model.Position;

import java.util.List;

public class ScatterTopLeft extends ScatterBehaviour {

    public ScatterTopLeft(Ghost ghost) {
        super(ghost, List.of(new Position(8, 2*12),
                             new Position(8, 12),
                             new Position(5*8, 12),
                             new Position(5*8, 2*12)));

    }
}
