package g0902.model.Game.Map;
import g0902.model.Game.MapElements.*;
import g0902.model.Game.MapElements.Coins.PowerCoin;
import g0902.model.Game.MapElements.Coins.SmallCoin;
import g0902.model.Game.MapElements.Ghosts.Ghost;
import g0902.model.Game.MapElements.Ghosts.Types.Cyan;
import g0902.model.Game.MapElements.Ghosts.Types.Orange;
import g0902.model.Game.MapElements.Ghosts.Types.Pink;
import g0902.model.Game.MapElements.Ghosts.Types.Red;
import g0902.model.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
    private Pacman pacman;
    private final List<Wall> walls;
    private final List<PowerCoin> powerCoins;
    private final HashMap<Position, SmallCoin> smallCoins;
    Ghost red, cyan, orange, pink;

    public Map(){
        walls = new ArrayList<>();
        smallCoins = new HashMap<>();
        powerCoins = new ArrayList<>();
    }

    public Pacman getPacman() {
        return pacman;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<PowerCoin> getPowerCoins() {
        return powerCoins;
    }

    public HashMap<Position, SmallCoin> getSmallCoins() {
        return smallCoins;
    }

    public Ghost getCyan() { return cyan;}

    public Ghost getOrange() {return orange;}

    public Ghost getPink() {return pink;}

    public Ghost getRed() {return red;}

    public void addWall(Wall wall) {
        walls.add(wall);
    }

    public void addPowerCoin(PowerCoin powerCoin) {powerCoins.add(powerCoin);}

    public void addSmallCoin(Position pos, SmallCoin smallCoin) {smallCoins.put(pos, smallCoin);}

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
        pacman.setMap(this);
    }

    public void setCyan(Ghost cyan) {
        this.cyan = cyan;
        ((Cyan) cyan).setMap(this);
    }

    public void setOrange(Ghost orange) {
        this.orange = orange;
        ((Orange) orange).setMap(this);
    }

    public void setPink(Ghost pink) {
        this.pink = pink;
        ((Pink) pink).setMap(this);
    }

    public void setRed(Ghost red) {
        this.red = red;
        ((Red) red).setMap(this);
    }

}
