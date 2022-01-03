package model.Elements.Ghosts.MoveMode.ChaseMode.TargetStrategys;

import model.Maps.Map;
import model.Position;

public interface TargetStrategy {
    Position getTarget(Position pos, Map map);
}
