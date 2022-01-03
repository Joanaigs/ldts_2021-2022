package model.Elements.Ghosts.MoveMode;

import model.Elements.Direction;
import model.Elements.Ghosts.Ghost;
import model.Maps.Map;
import model.Position;

import java.util.ArrayList;
import java.util.Random;

import static model.Elements.Direction.*;
import static model.Elements.Direction.None;

public abstract class MovingBehaviour{
    protected Ghost ghost;
    protected Map map;


    public MovingBehaviour(Ghost ghost) {
        this.ghost = ghost;
    }

    public void setMap(Map map) {
        this.map = map;
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
    
    protected ArrayList<Direction> setupPossibleDirections(long deltatime){
        // Array with every movement option
        ArrayList<Direction> directions = new ArrayList<>();
        directions.add(Up);
        directions.add(Left);
        directions.add(Down);
        directions.add(Right);

        // Remove oposite direction
        if (ghost.getCurrentDirection() == Left) {
            directions.remove(Right);
        } else if (ghost.getCurrentDirection() == Right) {
            directions.remove(Left);
        } else if (ghost.getCurrentDirection() == Up) {
            directions.remove(Down);
        } else if (ghost.getCurrentDirection() == Down) {
            directions.remove(Up);
        } else directions.remove(None);


        //Remove directions that make ghost collide with walls
        ArrayList<Direction> toRemove = new ArrayList<>();
        for (Direction direction : directions) {
            Position pos = ghost.move(deltatime, direction);
            Ghost tempGhost = new Ghost(pos);
            if (tempGhost.collideWithWall(map))
                toRemove.add(direction);
        }
        directions.removeAll(toRemove);
        return directions;
    }

}
