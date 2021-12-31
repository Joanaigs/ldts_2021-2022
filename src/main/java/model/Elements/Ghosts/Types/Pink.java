package model.Elements.Ghosts.Types;

import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseAggressive;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseAmbush;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseRandom;
import model.Maps.Map;
import model.Position;

public class Pink extends Ghost {
    public Pink(Position position) {
        super(position);
        setChaseBehaviour(new ChaseAmbush(this));
    }

    public void setMap(Map map){
        ((ChaseAmbush) getChaseBehaviour()).setMap(map);
    }
}
