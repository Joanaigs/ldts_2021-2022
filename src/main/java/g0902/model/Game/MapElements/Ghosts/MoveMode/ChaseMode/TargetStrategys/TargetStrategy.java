package g0902.model.Game.MapElements.Ghosts.MoveMode.ChaseMode.TargetStrategys;

import g0902.model.Game.Map.Map;
import g0902.model.Position;

public interface TargetStrategy {
    Position getTarget(Position pos, Map map);
}
