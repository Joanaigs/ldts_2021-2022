package model.Elements.Ghosts.Moves.ScatterMode;

import model.Elements.Ghosts.Ghost;
import model.Position;

import java.util.List;

public class ScatterTopLeft extends ScatterBehaviour {

    public ScatterTopLeft(Ghost ghost) {
        super(ghost, List.of(new Position(1*8, 2*12),
                             new Position(1*8, 1*12),
                             new Position(5*8, 1*12),
                             new Position(5*8, 2*12)));

    }
}
