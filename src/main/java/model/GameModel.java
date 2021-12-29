package model;

import model.Elements.*;
import model.Elements.Coins.Coin;
import model.Elements.Coins.PowerCoin;
import model.Elements.Coins.SmallCoin;
import model.Maps.Builders.MapBuilder;
import model.Maps.Builders.MapReader;
import model.Maps.Map;

import java.io.IOException;
import java.util.ArrayList;

public class GameModel implements Model{
    private Map map;
    private ArrayList<Coin> toRemove;
    boolean wasSmallCoin;

    public GameModel() throws IOException {
        MapBuilder mapBuilder = new MapReader();
        map = mapBuilder.createMap("map");
    }

    public Map getMap() {
        return map;
    }

    boolean collideWithWalls(Collider collider){
        for( Wall wall: map.getWalls()){
            if( wall.getCollider().colision(collider))
                return true;
        }

        return false;
    }

    boolean collideWithSmallCoin(Collider collider){
        for( Coin sm: map.getSmallCoins() ){
            if( sm.getCollider().colision(collider))
                return true;
        }

        return false;
    }


    public void updateAux(long deltatime) {

        Pacman pacman = map.getPacman();

        Position oldPosition = new Position(pacman.getPosition().getRow(), pacman.getPosition().getCol());

        Position next = pacman.moveNextDirection(deltatime);
        if (collideWithWalls(new Collider(next, pacman.getCollider().getWidth(), pacman.getCollider().getHeight()))) {
            next = pacman.moveCurrentDirection(deltatime);

            if (collideWithWalls(new Collider(next, pacman.getCollider().getWidth(), pacman.getCollider().getHeight()))) {
                pacman.setPosition(oldPosition);
                pacman.setDirection(Direction.None);
            } else {
                pacman.setPosition(next);
            }
        } else {
            if (pacman.getNextDirection() != pacman.getCurrentDirection()) {
                int row = (int) Math.round(next.getRow() / 8.0);
                int col = (int) Math.round(next.getCol() / 12.0);

                switch (pacman.getNextDirection()) {
                    case Up:
                    case Down:
                        next.setCol(col * 12 + 1);
                        break;

                    case Left:
                    case Right:
                        next.setRow(row * 8 + 1);
                        break;
                }
            }
            pacman.setPosition(next);
            pacman.nextDirection();
        }

        wasSmallCoin = false;
        toRemove = new ArrayList<>();
        for (SmallCoin smallCoin : map.getSmallCoins()) {
            if (smallCoin.getCollider().colision(pacman.getCollider())) {
                toRemove.add(smallCoin);
                pacman.increaseScore(SmallCoin.SmallCoinValue);
                wasSmallCoin = true;
                break;
            }
        }
        map.getSmallCoins().removeAll(toRemove);

        if (!wasSmallCoin){
            for (PowerCoin powerCoin : map.getPowerCoins()) {
                if (powerCoin.getCollider().colision(pacman.getCollider())) {
                    toRemove.add(powerCoin);
                    pacman.increaseScore(PowerCoin.PowerCoinValue);
                    break;
                }
            }
            map.getPowerCoins().removeAll(toRemove);
        }
   }


    // MUDAR PARA GAME LOOP
    public void update(long deltatime){
        for(int i = 0; i<3;i++)
            updateAux(deltatime);
    }

    public boolean isRunning(){         // TO CHANGE LATER
        return true;
    }
}
