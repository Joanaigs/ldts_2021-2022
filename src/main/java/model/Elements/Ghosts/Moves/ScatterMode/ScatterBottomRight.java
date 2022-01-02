package model.Elements.Ghosts.Moves.ScatterMode;

import model.Elements.Direction;
import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Moves.MovingBehaviorJoana;
import model.Position;

import java.util.Vector;

public class ScatterBottomRight extends MovingBehaviorJoana implements ScatterBehaviour{
    Vector<Position> keyPoints;
    Position toGoPosition;

    public ScatterBottomRight(Ghost ghost) {
        super(ghost);
        keyPoints=new Vector<>();
        keyPoints.add(new Position(35*8, 38*12));
        keyPoints.add(new Position(35*8, 24*12));
        keyPoints.add(new Position(38*8, 24*12));
        keyPoints.add(new Position(38*8, 38*12));
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

    @Override
    public Direction Scatter(long deltatime) {
        return moving(deltatime);
    }

    @Override
    public double calculateDistance(Position pos1) {
        findToGoPosition();
        double dis;
        dis = Math.sqrt((toGoPosition.getCol() - pos1.getCol()) * (toGoPosition.getCol() - pos1.getCol()) + (toGoPosition.getRow() - pos1.getRow()) * (toGoPosition.getRow() - pos1.getRow()));
        return dis;
    }
}
