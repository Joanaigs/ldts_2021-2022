package model.Elements.Ghosts.Types;

import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseAggressive;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseRandom;
import model.Elements.Ghosts.Moves.ScatterMode.ScatterBottomLeft;
import model.Elements.Ghosts.Moves.ScatterMode.ScatterTopLeft;
import model.Maps.Map;
import model.Position;

public class Orange  extends Ghost {

    public Orange(Position position) {
        super(position);
        setChaseBehaviour(new ChaseRandom(this));
        setScatterBehaviour(new ScatterBottomLeft(this));
    }

    public void setMap(Map map){
        ((ChaseRandom) getChaseBehaviour()).setMap(map);
        ((ScatterBottomLeft)getScatterBehaviour()).setMap(map);
    }
}
