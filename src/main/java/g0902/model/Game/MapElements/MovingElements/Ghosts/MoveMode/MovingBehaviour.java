package g0902.model.Game.MapElements.MovingElements.Ghosts.MoveMode;

import g0902.model.Direction;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Ghost;
import g0902.model.Position;

import java.util.ArrayList;
import java.util.Random;

import static g0902.model.Direction.*;
import static g0902.model.Direction.None;

public abstract class MovingBehaviour{
    protected Ghost ghost;

    public MovingBehaviour(Ghost ghost) {
        this.ghost = ghost;
    }

    protected double calculateDistance(Position pos1, Position pos2){
        double dis;
        dis = Math.sqrt((pos2.getCol() - pos1.getCol()) * (pos2.getCol() - pos1.getCol()) + (pos2.getRow() - pos1.getRow()) * (pos2.getRow() - pos1.getRow()));
        return dis;
    }

    protected int correspondenceToSmallestDistance(ArrayList<Double> dists) {
        int index = 0;
        for (int i = 1; i < dists.size(); i++) {
            if (dists.get(i) < dists.get(index)) {
                index = i;
            }
        }

        return index;
    }

    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    protected ArrayList<Direction> removeOppositeDirections(ArrayList<Direction> directions){
        if (ghost.getCurrentDirection() == Left) {
            directions.remove(Right);
        } else if (ghost.getCurrentDirection() == Right) {
            directions.remove(Left);
        } else if (ghost.getCurrentDirection() == Up) {
            directions.remove(Down);
        } else if (ghost.getCurrentDirection() == Down) {
            directions.remove(Up);
        } else directions.remove(None);

        return directions;
    }

    protected ArrayList<Direction> removeCollidingDirections(ArrayList<Direction> directions, long deltatime){
        ArrayList<Direction> toRemove = new ArrayList<>();
        for (Direction direction : directions) {
            Position pos = ghost.move(deltatime, direction);
            Ghost tempGhost = new Ghost(pos);
            if (ghost.collideWithWall(tempGhost.getCollider()))
                toRemove.add(direction);
        }
        directions.removeAll(toRemove);
        return directions;
    }
    
    protected ArrayList<Direction> setupPossibleDirections(long deltatime){
        ArrayList<Direction> directions = new ArrayList<>();  // Array with every movement option
        directions.add(Up);
        directions.add(Left);
        directions.add(Down);
        directions.add(Right);

        removeOppositeDirections(directions);   // Remove opposite direction to the one ghost was doing
        removeCollidingDirections(directions, deltatime);  //Remove directions that make ghost collide with walls
        return directions;
    }
}
