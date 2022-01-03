package model.Elements.Ghosts.MoveMode.ScatterMode;

import model.Elements.Ghosts.Ghost;
import model.Position;

import java.util.List;


public class ScatterBottomRight extends ScatterBehaviour {

    public ScatterBottomRight(Ghost ghost) {
        super(ghost, List.of(new Position(35*8, 38*12),
                             new Position(35*8, 24*12),
                             new Position(38*8, 24*12),
                             new Position(38*8, 38*12)));

    }

}
