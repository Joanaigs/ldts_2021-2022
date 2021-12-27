package model.Maps;

//import model.Elements.Ghosts.model.Elements.Ghost.Ghost;
//import model.Elements.Pellets.PowerPellet;
//import model.Elements.Pellets.SmallPellet;

import model.Elements.Wall;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Wall> walls;
    private final int width;
    private final int height;

    public Map(int width, int height){
        walls = new ArrayList<>();
        this.width = width;
        this.height = height;
    }


    public List<Wall> getWalls() {
        return walls;
    }


    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

}
