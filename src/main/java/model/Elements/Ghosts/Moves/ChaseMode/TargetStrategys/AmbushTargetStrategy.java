package model.Elements.Ghosts.Moves.ChaseMode.TargetStrategys;

import model.Maps.Map;
import model.Position;

public class AmbushTargetStrategy implements TargetStrategy {

    @Override
    public Position getTarget(Position pos, Map map) {
        int targetCol;
        int targetRow;

        switch(map.getPacman().getCurrentDirection()){
            case Down:
                targetCol = map.getPacman().getPosition().getCol();
                targetRow = map.getPacman().getPosition().getRow() +4*8;    // a little lower
                break;

            case Up:
                targetRow = map.getPacman().getPosition().getRow() -4*8;
                if(pos.getCol() < map.getPacman().getPosition().getCol())
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
}
