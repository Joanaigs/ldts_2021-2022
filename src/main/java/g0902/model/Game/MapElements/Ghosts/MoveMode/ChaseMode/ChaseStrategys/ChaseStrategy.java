package g0902.model.Game.MapElements.Ghosts.MoveMode.ChaseMode.ChaseStrategys;

import g0902.model.Direction;

public interface ChaseStrategy {

    Direction chase(long deltatime);
}
