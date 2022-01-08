package g0902.model.Elements.Ghosts.MoveMode.ChaseMode.TargetStrategys;

import g0902.model.Maps.Map;
import g0902.model.Position;

public interface TargetStrategy {
    Position getTarget(Position pos, Map map);
}
