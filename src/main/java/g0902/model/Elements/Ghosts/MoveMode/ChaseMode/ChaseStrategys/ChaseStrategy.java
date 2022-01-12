package g0902.model.Elements.Ghosts.MoveMode.ChaseMode.ChaseStrategys;

import g0902.model.Direction;

public interface ChaseStrategy {

    Direction chase(long deltatime);
}
