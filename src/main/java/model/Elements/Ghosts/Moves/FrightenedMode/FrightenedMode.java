package model.Elements.Ghosts.Moves.FrightenedMode;

import model.Elements.Direction;
import model.Elements.Ghosts.Ghost;
import model.Maps.Map;
import model.Position;

import java.util.ArrayList;
import java.util.Random;


public class FrightenedMode implements FrightenedBehaviour{
    Ghost ghost;
    private Map map;
    private int numCalls;

    public FrightenedMode(Ghost ghost){
        this.ghost = ghost;
        numCalls = 0;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
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
            // Array with every movement option
            ArrayList<Direction> directions = new ArrayList<>();
            directions.add(Direction.Up);
            directions.add(Direction.Left);
            directions.add(Direction.Down);
            directions.add(Direction.Right);

            // Remove opposite direction
            if (ghost.getCurrentDirection() == Direction.Left) {
                directions.remove(Direction.Right);
            } else if (ghost.getCurrentDirection() == Direction.Right) {
                directions.remove(Direction.Left);
            } else if (ghost.getCurrentDirection() == Direction.Up) {
                directions.remove(Direction.Down);
            } else if (ghost.getCurrentDirection() == Direction.Down) {
                directions.remove(Direction.Up);
            }


            //Remove directions that make ghost collide with walls
            ArrayList<Direction> toRemove = new ArrayList<>();
            for (Direction direction : directions) {
                Position pos = ghost.move(deltatime, direction);
                Ghost tempGhost = new Ghost(pos);
                if (tempGhost.collideWithWall(map))
                    toRemove.add(direction);
            }
            directions.removeAll(toRemove);

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
