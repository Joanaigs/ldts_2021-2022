package g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode.ChaseMode.ChaseStrategys;

import g0902.model.Direction;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Ghost;
import g0902.model.Game.MapElements.MovingElements.Ghosts.MovingBehaviour;

import java.util.ArrayList;


public class RandomChaseStrategy extends MovingBehaviour implements ChaseStrategy {

    public RandomChaseStrategy(Ghost ghost) {
        super(ghost);
    }

    @Override
    public Direction chase(long deltatime) {

        // Array with every movement option
        ArrayList<Direction> directions = setupPossibleDirections(deltatime);

        if(directions.size() > 1)
            return directions.get(getRandomNumberInRange(0, directions.size()-1));
        else if(directions.size() == 1)
            return directions.get(0);

        return ghost.getCurrentDirection();
    }
}
