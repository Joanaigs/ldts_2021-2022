package model.Elements.Ghosts.Moves.ScatterMode;

import model.Elements.Direction;
import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Moves.MovingBehaviour;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class ScatterBehaviour extends MovingBehaviour{
    List<Position> keyPoints;
    Position toGoPosition;

    public ScatterBehaviour(Ghost ghost, List<Position> keyPoints) {
        super(ghost);
        this.keyPoints = keyPoints;
        toGoPosition=keyPoints.get(0);
    }

    public void findToGoPosition(){
        if(ghost.getPosition()==keyPoints.get(0))
            toGoPosition=keyPoints.get(1);
        else if(ghost.getPosition()==keyPoints.get(1))
            toGoPosition=keyPoints.get(2);
        else if(ghost.getPosition()==keyPoints.get(2))
            toGoPosition=keyPoints.get(3);
        else if(ghost.getPosition()==keyPoints.get(3))
            toGoPosition=keyPoints.get(0);
    }


    public Direction Scatter(long deltatime) {

        findToGoPosition();
        ArrayList<Direction> directions = setupPossibleDirections(deltatime);

        if (directions.size() == 1)
            return directions.get(0);

        ArrayList<Double> dists = new ArrayList<>();
        for (Direction direction : directions) {
            Position pos = ghost.move(deltatime, direction);
            dists.add(calculateDistance(pos, toGoPosition));
        }

        return directions.get(correspondenceToSmallestDistance(dists));
    }
}
