package model.Elements.Ghosts.MoveMode.ChaseMode.ChaseStrategys;

import model.Elements.Direction;

public interface ChaseStrategy {

    Direction chase(long deltatime);
}
