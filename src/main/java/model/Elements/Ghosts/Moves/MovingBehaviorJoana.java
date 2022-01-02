package model.Elements.Ghosts.Moves;

import model.Elements.Direction;
import model.Elements.Ghosts.Ghost;
import model.Maps.Map;
import model.Position;

import java.util.ArrayList;

public abstract class MovingBehavior {
    protected Ghost ghost;
    private Map map;


    public MovingBehavior(Ghost ghost) {
        this.ghost = ghost;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public abstract double calculateDistance(Position pos1);

    public int correspondenceToSmallestDistance(ArrayList<Double> dists) {
        int index = 0;
        for (int i = 1; i < dists.size(); i++) {
            if (dists.get(i) < dists.get(index)) {
                index = i;
            }
        }

        return index;
    }

    public Direction moving(long deltatime) {

        // Array with every movement option
        ArrayList<Direction> directions = new ArrayList<>();
        directions.add(Direction.Up);
        directions.add(Direction.Left);
        directions.add(Direction.Down);
        directions.add(Direction.Right);

        // Remove oposite direction
        if (ghost.getCurrentDirection() == Direction.Left) {
            directions.remove(Direction.Right);
        } else if (ghost.getCurrentDirection() == Direction.Right) {
            directions.remove(Direction.Left);
        } else if (ghost.getCurrentDirection() == Direction.Up) {
            directions.remove(Direction.Down);
        } else if (ghost.getCurrentDirection() == Direction.Down) {
            directions.remove(Direction.Up);
        } else directions.remove(Direction.None);


        //Remove directions that make ghost collide with walls
        ArrayList<Direction> toRemove = new ArrayList<>();
        for (Direction direction : directions) {
            Position pos = ghost.move(deltatime, direction);
            Ghost tempGhost = new Ghost(pos);
            if (tempGhost.collideWithWall(map))
                toRemove.add(direction);
        }
        directions.removeAll(toRemove);

        if (directions.size() == 1)
            return directions.get(0);

        ArrayList<Double> dists = new ArrayList<>();
        for (Direction direction : directions) {
            Position pos = ghost.move(deltatime, direction);
            dists.add(calculateDistance(pos));
        }

        return directions.get(correspondenceToSmallestDistance(dists));

    }
}
