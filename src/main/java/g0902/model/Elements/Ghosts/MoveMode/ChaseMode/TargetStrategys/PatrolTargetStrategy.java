package g0902.model.Elements.Ghosts.MoveMode.ChaseMode.TargetStrategys;

import g0902.model.Maps.Map;
import g0902.model.Position;

public class PatrolTargetStrategy implements TargetStrategy {

    @Override
    public Position getTarget(Position pos, Map map) {
        int tempTargetCol, tempTargetRow;
        int redCol = map.getRed().getPosition().getCol();
        int redRow = map.getRed().getPosition().getRow();

        // set an intermediate temporary target, based on pacman position
        switch(map.getPacman().getCurrentDirection()){
            case Down:
                tempTargetCol = map.getPacman().getPosition().getCol();
                tempTargetRow = map.getPacman().getPosition().getRow() +2*8;
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
}
