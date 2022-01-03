package model.Elements.Ghosts.Moves.FrightenedMode;

import model.Elements.Direction;
import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Moves.MovingBehaviour;


import java.util.ArrayList;


public class FrightenedMode extends MovingBehaviour implements FrightenedBehaviour{
    private int numCalls;

    public FrightenedMode(Ghost ghost){
        super(ghost);
        numCalls = 0;
    }

    @Override
    public Direction frightened(long deltatime) {

        if(numCalls==0){
            switch(ghost.getCurrentDirection()){
                case Left:
                    ghost.setCurrentDirection(Direction.Right);
                    break;
                case Right:
                    ghost.setCurrentDirection(Direction.Left);
                    break;
                case Up:
                    ghost.setCurrentDirection(Direction.Down);
                    break;
                case Down:
                    ghost.setCurrentDirection(Direction.Up);
                    break;
                case None:
                    break;
            }
        }

        else {
            ArrayList<Direction> directions = setupPossibleDirections(deltatime);
            if (directions.size() > 1)
                return directions.get(getRandomNumberInRange(0, directions.size() - 1));
            else if (directions.size() == 1)
                return directions.get(0);
        }

        numCalls++;
        //por numCalls a zero quando o tempo terminar
        return ghost.getCurrentDirection();
    }
}
