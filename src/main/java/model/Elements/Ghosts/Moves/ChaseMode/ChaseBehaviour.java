package model.Elements.Ghosts.Moves.ChaseMode;

import model.Elements.Direction;

public interface ChaseBehaviour {

    public Direction chase(long deltatime);
}

