package g0902.model.Game.MapElements.Ghosts.MoveMode.FrightenedMode;

import g0902.model.Direction;
import g0902.model.Game.MapElements.Ghosts.Ghost;
import g0902.model.Game.MapElements.Ghosts.MoveMode.MovingBehaviour;

import java.util.ArrayList;


public class FrightenedMode extends MovingBehaviour implements FrightenedBehaviour {

    public FrightenedMode(Ghost ghost) {
        super(ghost);
    }

    protected void firstFrightenedMove() {
     switch(ghost.getCurrentDirection()){
        case Left:
            ghost.setCurrentDirection(Direction.Right);
            break;
        case Right:
            ghost.setCurrentDirection(Direction.Left);
            break;
        case Up:
            ghost.setCurrentDirection(Direction.Down);
            break;
        case Down:
            ghost.setCurrentDirection(Direction.Up);
            break;
        case None:
            break;
    }
}

    @Override
    public Direction frightened(long deltatime) {

        if(ghost.getFrightenedTime()==0)
            firstFrightenedMove();  // sets CurrentDirection to the one opposite

        else {
            ArrayList<Direction> directions = setupPossibleDirections(deltatime);
            if (directions.size() > 1)
                return directions.get(getRandomNumberInRange(0, directions.size() - 1));
            else if (directions.size() == 1)
                return directions.get(0);
        }
        return ghost.getCurrentDirection();
    }
}
