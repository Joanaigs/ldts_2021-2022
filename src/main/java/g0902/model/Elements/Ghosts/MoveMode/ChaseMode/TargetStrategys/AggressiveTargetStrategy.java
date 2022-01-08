package g0902.model.Elements.Ghosts.MoveMode.ChaseMode.TargetStrategys;

import g0902.model.Maps.Map;
import g0902.model.Position;

public class AggressiveTargetStrategy implements TargetStrategy {

    @Override
    public Position getTarget(Position pos, Map map) {
        int pacmanCol = map.getPacman().getPosition().getCol();
        int pacmanRow = map.getPacman().getPosition().getRow();
        return new Position(pacmanRow, pacmanCol);
    }
}
