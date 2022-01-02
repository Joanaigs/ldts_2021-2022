package model.Elements.Ghosts.Moves.ChaseMode;

import model.Elements.Direction;
import model.Elements.Ghosts.Ghost;
import model.Maps.Map;
import model.Position;

import java.util.ArrayList;

import static model.Elements.Direction.*;

public class ChasePatrol extends MovingBehaviour implements ChaseBehaviour{

    public ChasePatrol(Ghost ghost) {
        super(ghost);
    }


    protected Position setTarget(Position pos1){
            int tempTargetCol, tempTargetRow;
            int redCol = map.getRed().getPosition().getCol();
            int redRow = map.getRed().getPosition().getRow();

            // set an intermediate temporary target, based on pacman position
            switch(map.getPacman().getCurrentDirection()){
                case Down:
                    tempTargetCol = map.getPacman().getPosition().getCol();
                    tempTargetRow = map.getPacman().getPosition().getRow() +2*8;
                    break;

                case Up:
                    tempTargetRow = map.getPacman().getPosition().getRow() -2*8;
                    if(pos1.getCol() < map.getPacman().getPosition().getCol())
                        tempTargetCol = map.getPacman().getPosition().getCol()+2*12;
                    else tempTargetCol = map.getPacman().getPosition().getCol()+2*12;
                    break;

                case Left:
                    tempTargetCol = map.getPacman().getPosition().getCol()-2*12;
                    tempTargetRow = map.getPacman().getPosition().getRow();
                    break;

                case Right:
                    tempTargetCol = map.getPacman().getPosition().getCol()+2*12;
                    tempTargetRow = map.getPacman().getPosition().getRow();
                    break;

                default:
                    tempTargetRow = map.getPacman().getPosition().getRow() -2*8;
                    tempTargetCol = map.getPacman().getPosition().getCol()+2*12;
                    break;
            }

            // vector target-red, and then gotta rotate it 180º( it stays (-x, -y) ). After that, I sum it to the target position
            int targetRow = tempTargetRow - (redRow - tempTargetRow);
            int targetCol =  tempTargetCol - (redCol-tempTargetCol);

            return new Position(targetRow, targetCol);
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
