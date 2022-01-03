package model.Elements.Ghosts.Moves.ChaseMode.ChaseStrategys;

import model.Elements.Direction;

public interface ChaseStrategy {

    Direction chase(long deltatime);
}
