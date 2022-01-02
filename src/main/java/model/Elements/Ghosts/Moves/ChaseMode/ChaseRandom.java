package model.Elements.Ghosts.Moves.ChaseMode;

import model.Elements.Direction;
import model.Elements.Ghosts.Ghost;
import model.Maps.Map;
import model.Position;

import java.util.ArrayList;
import java.util.Random;

public class ChaseRandom extends MovingBehaviour implements ChaseBehaviour {

    public ChaseRandom(Ghost ghost){
        super(ghost);
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
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
