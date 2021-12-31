package model.Elements.Ghosts.Types;

import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseAggressive;
import model.Elements.Ghosts.Moves.ChaseMode.ChaseRandom;
import model.Elements.Pacman;
import model.Maps.Map;
import model.Position;

public class Red extends Ghost {

    public Red(Position position) {
        super(position);
        setChaseBehaviour(new ChaseAggressive(this));
    }

    public void setMap(Map map){
        ((ChaseAggressive) getChaseBehaviour()).setMap(map);
    }

}
