package model.Elements.Ghosts.Moves.ScatterMode;

import model.Elements.Ghosts.Ghost;

import model.Position;
import java.util.List;

public class ScatterBottomLeft extends ScatterBehaviour {

    public ScatterBottomLeft(Ghost ghost) {
        super(ghost, List.of(new Position(35*8, 12),
                             new Position(38*8, 12),
                             new Position(38*8, 17*12),
                             new Position(35*8, 17*12)));

    }

}
