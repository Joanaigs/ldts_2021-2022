package model.Elements.Ghosts.Moves.ChaseMode.ChaseStrategys;

import model.Elements.Direction;
import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Moves.MovingBehaviour;

import java.util.ArrayList;
import java.util.Random;

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
