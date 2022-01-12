package g0902.model.Game.MapElements.Ghosts.MoveMode.ScatterMode;

import g0902.model.Game.MapElements.Ghosts.Ghost;

import g0902.model.Position;
import java.util.List;

public class ScatterBottomLeft extends ScatterBehaviour {

    public ScatterBottomLeft(Ghost ghost) {
        super(ghost, List.of(new Position(35*8, 12),
                             new Position(38*8, 12),
                             new Position(38*8, 17*12),
                             new Position(35*8, 17*12)));

    }

}
