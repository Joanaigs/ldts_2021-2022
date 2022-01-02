package model.Elements.Ghosts.Moves.ChaseMode;

import model.Elements.Direction;
import model.Elements.Ghosts.Ghost;
import model.Maps.Map;
import model.Position;

import java.util.ArrayList;

public class ChaseAggressive extends MovingBehaviour implements ChaseBehaviour {

    public ChaseAggressive(Ghost ghost) {super(ghost);}


    protected Position setTarget(Position pos1){
        int pacmanCol = map.getPacman().getPosition().getCol();
        int pacmanRow = map.getPacman().getPosition().getRow();
        return new Position(pacmanRow, pacmanCol);
    }


    @Override
    // retorna a direção para onde vai
    public Direction chase(long deltatime) {

        ArrayList<Direction> directions = setupPossibleDirections(deltatime);

        if (directions.size() == 1)
            return directions.get(0);

        Position targetPosition;

        ArrayList<Double> dists = new ArrayList<>();
        for (Direction direction : directions) {
            Position pos = ghost.move(deltatime, direction);
            targetPosition = setTarget(pos);
            dists.add(calculateDistance(pos, targetPosition));
        }

        return directions.get(correspondenceToSmallestDistance(dists));

    }
}