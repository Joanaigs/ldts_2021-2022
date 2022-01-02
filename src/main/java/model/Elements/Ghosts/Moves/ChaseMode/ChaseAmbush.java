package model.Elements.Ghosts.Moves.ChaseMode;

import model.Elements.Direction;
import model.Elements.Ghosts.Ghost;
import model.Maps.Map;
import model.Position;

import java.util.ArrayList;

import static model.Elements.Direction.*;

public class ChaseAmbush extends MovingBehaviour implements ChaseBehaviour{

    public ChaseAmbush(Ghost ghost) {
        super(ghost);
    }

    protected Position setTarget(Position pos1) {
        int targetCol;
        int targetRow;

        switch(map.getPacman().getCurrentDirection()){
            case Down:
                targetCol = map.getPacman().getPosition().getCol();
                targetRow = map.getPacman().getPosition().getRow() +4*8;    // a little lower
                break;

            case Up:
                targetRow = map.getPacman().getPosition().getRow() -4*8;
                if(pos1.getCol() < map.getPacman().getPosition().getCol())
                    targetCol = map.getPacman().getPosition().getCol()+4*12;
                else targetCol = map.getPacman().getPosition().getCol()+4*12;
                break;

            case Left:
                targetCol = map.getPacman().getPosition().getCol()-4*12;
                targetRow = map.getPacman().getPosition().getRow();
                break;

            case Right:
                targetCol = map.getPacman().getPosition().getCol()+4*12;
                targetRow = map.getPacman().getPosition().getRow();
                break;

            default:
                targetRow = map.getPacman().getPosition().getRow() -4*8;
                targetCol = map.getPacman().getPosition().getCol()+4*12;
                break;
        }

        return new Position(targetRow, targetCol);
    }


    @Override
    // retorna a direção para onde vai
    public Direction chase(long deltatime) {

        // Array with every movement option
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
