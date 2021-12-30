package model.Maps;
import model.Elements.*;
import model.Elements.Coins.Coin;
import model.Elements.Coins.PowerCoin;
import model.Elements.Coins.SmallCoin;
import model.Elements.Ghosts.Ghost;
import model.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
    private Pacman pacman;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<PowerCoin> powerCoins;
    private HashMap<Position, SmallCoin> smallCoins;
    private final int width;
    private final int height;
    Ghost Red, Cyan, Orange, Pink;

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

    public List<Coin> getCoins() {
        return coins;
    }

    public List<PowerCoin> getPowerCoins() {
        return powerCoins;
    }

    public HashMap<Position, SmallCoin> getSmallCoins() {
        return smallCoins;
    }

    public Ghost getCyan() { return Cyan;}

    public Ghost getOrange() {return Orange;}

    public Ghost getPink() {return Pink;}

    public Ghost getRed() {return Red;}

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setPacman(Pacman pacman) {this.pacman = pacman;}

    public void setCoins(List<Coin> coins) {this.coins = coins;}

    public void setPowerCoins(List<PowerCoin> powerCoins) {this.powerCoins = powerCoins;}

    public void setSmallCoins(HashMap<Position, SmallCoin> smallCoins) {this.smallCoins = smallCoins;}

    public void setCyan(Ghost cyan) {
        Cyan = cyan;
    }

    public void setOrange(Ghost orange) {
        Orange = orange;
    }

    public void setPink(Ghost pink) {
        Pink = pink;
    }

    public void setRed(Ghost red) {
        Red = red;
    }

}
