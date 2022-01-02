package model.Elements.Ghosts.Types;

import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseAggressive;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseAmbush;
import model.Elements.Ghosts.Moves.ChaseMode.ChasePatrol;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseRandom;
import model.Elements.Ghosts.Moves.ScatterMode.ScatterBottomLeft;
import model.Elements.Ghosts.Moves.ScatterMode.ScatterBottomRight;
import model.Elements.Ghosts.Moves.FrightenedMode.FrightenedBehaviour;
import model.Elements.Ghosts.Moves.FrightenedMode.FrightenedMode;
import model.Maps.Map;
import model.Position;

public class Cyan extends Ghost {

    public Cyan(Position position) {
        super(position);
        setChaseBehaviour(new ChasePatrol(this));
        setFrightenedBehaviour(new FrightenedMode(this));
        setScatterBehaviour(new ScatterBottomRight(this));
    }

    public void setMap(Map map){
        ((ChasePatrol) getChaseBehaviour()).setMap(map);
        ((ScatterBottomRight)getScatterBehaviour()).setMap(map);
        ((FrightenedMode) getFrightenedBehaviour()).setMap(map);
    }
}
