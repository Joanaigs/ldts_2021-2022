package model.Elements.Ghosts.Types;

import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseAggressive;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseAmbush;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseRandom;
import model.Elements.Ghosts.Moves.ScatterMode.ScatterBottomLeft;
import model.Elements.Ghosts.Moves.ScatterMode.ScatterBottomRight;
import model.Maps.Map;
import model.Position;

public class Cyan extends Ghost {

    public Cyan(Position position) {
        super(position);
        setChaseBehaviour(new ChaseRandom(this));
        setScatterBehaviour(new ScatterBottomRight(this));
    }

    public void setMap(Map map){
        ((ChaseRandom) getChaseBehaviour()).setMap(map);
        ((ScatterBottomRight)getScatterBehaviour()).setMap(map);
    }
}
