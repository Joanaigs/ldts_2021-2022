package model.Maps;
import model.Elements.*;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private Pacman pacman;
    private List<Wall> walls;
    private List<Coins> coins;
    private List<PowerCoin> powerCoins;
    private List<SmallCoin> smallCoins;
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

    public List<Coins> getCoins() {
        return coins;
    }

    public List<PowerCoin> getPowerCoins() {
        return powerCoins;
    }

    public List<SmallCoin> getSmallCoins() {
        return smallCoins;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setPacman(Pacman pacman) {this.pacman = pacman;}

    public void setCoins(List<Coins> coins) {this.coins = coins;}

    public void setPowerCoins(List<PowerCoin> powerCoins) {this.powerCoins = powerCoins;}

    public void setSmallCoins(List<SmallCoin> smallCoins) {this.smallCoins = smallCoins;}
}
