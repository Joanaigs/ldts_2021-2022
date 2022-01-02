package model.Elements.Ghosts.Types;

import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseAggressive;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseAmbush;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseRandom;
import model.Elements.Ghosts.Moves.FrightenedMode.FrightenedBehaviour;
import model.Elements.Ghosts.Moves.FrightenedMode.FrightenedMode;
import model.Elements.Ghosts.Moves.ScatterMode.ScatterTopLeft;
import model.Elements.Ghosts.Moves.ScatterMode.ScatterTopRight;
import model.Maps.Map;
import model.Position;

public class Pink extends Ghost {

    public Pink(Position position) {
        super(position);
        setChaseBehaviour(new ChaseAmbush(this));
        setFrightenedBehaviour(new FrightenedMode(this));
        setScatterBehaviour(new ScatterTopLeft(this));
    }

    public void setMap(Map map){
        ((ChaseAmbush) getChaseBehaviour()).setMap(map);
        ((ScatterTopLeft)getScatterBehaviour()).setMap(map);
        ((FrightenedMode) getFrightenedBehaviour()).setMap(map);
    }

}
