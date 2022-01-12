package g0902.model.Game.MapElements.Ghosts.MoveMode.ChaseMode.ChaseStrategys;

import g0902.model.Direction;
import g0902.model.Game.MapElements.Ghosts.Ghost;
import g0902.model.Game.MapElements.Ghosts.MoveMode.MovingBehaviour;
import g0902.model.Game.MapElements.Ghosts.MoveMode.ChaseMode.TargetStrategys.TargetStrategy;
import g0902.model.Position;

import java.util.ArrayList;

public class TargetChaseStrategy extends MovingBehaviour implements ChaseStrategy {
    TargetStrategy targetStrategy;

    public TargetChaseStrategy(TargetStrategy targetStrategy, Ghost ghost) {
        super(ghost);
        this.targetStrategy = targetStrategy;
    }

    @Override
    public Direction chase(long deltatime) {
        ArrayList<Direction> directions = setupPossibleDirections(deltatime);
        if (directions.size() == 1)
            return directions.get(0);

        Position targetPosition;
        ArrayList<Double> dists = new ArrayList<>();
        for (Direction direction : directions) {
            Position pos = ghost.move(deltatime, direction);
            targetPosition = targetStrategy.getTarget(pos, ghost.getMap());
            dists.add(calculateDistance(pos, targetPosition));
        }
        return directions.get(correspondenceToSmallestDistance(dists));
    }
}
