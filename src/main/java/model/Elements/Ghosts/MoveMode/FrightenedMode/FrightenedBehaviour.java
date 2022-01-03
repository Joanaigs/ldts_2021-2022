package model.Elements.Ghosts.Moves.FrightenedMode;

import model.Elements.Direction;
import model.Elements.Ghosts.Ghost;

public interface FrightenedBehaviour {
    public Direction frightened(long deltatime);
}
