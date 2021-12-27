package model.Maps;
import model.Elements.*;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private Pacman pacman;
    private List<Wall> walls;
    private final int width;
    private final int height;

    public Map(int width, int height){
        walls = new ArrayList<>();
        this.width = width;
        this.height = height;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setPacman(Pacman readPacman) {pacman = readPacman;}
}
