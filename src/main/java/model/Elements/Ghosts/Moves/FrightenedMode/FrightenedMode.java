package model.Elements.Ghosts.Moves;

import model.Elements.Direction;
import model.Elements.Ghosts.Ghost;
import model.Maps.Map;
import model.Position;

import java.util.ArrayList;
import java.util.Random;

public class FrightenedMode{
    Ghost ghost;
    private Map map;

    FrightenedMode(Ghost ghost){
        this.ghost = ghost;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
//  ver video