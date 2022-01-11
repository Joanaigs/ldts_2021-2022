package g0902.model;

import g0902.model.Elements.*;
import g0902.model.Elements.Coins.Coin;
import g0902.model.Elements.Coins.PowerCoin;
import g0902.model.Elements.Coins.SmallCoin;
import g0902.model.Elements.Ghosts.Ghost;
import g0902.model.Maps.Builders.MapBuilder;
import g0902.model.Maps.Builders.MapReader;
import g0902.model.Maps.Map;

import java.io.IOException;
import java.util.ArrayList;

public class GameModel implements Model{
    private Map map;
    private ArrayList<Coin> toRemove;
    boolean wasSmallCoin;
    int score;
    Ghost red, pink, cyan, orange;
    Pacman pacman;
    int lives;
    boolean isRunning;
    boolean lost;

    public GameModel() throws IOException {
        MapBuilder mapBuilder = new MapReader();
        map = mapBuilder.createMap("map");
        red = map.getRed();
        pink = map.getPink();
        cyan = map.getCyan();
        orange = map.getOrange();
        pacman = map.getPacman();
        isRunning=true;
        lives=3;
        lost=false;
    }

    public Map getMap() {
        return map;
    }

    boolean collideWithWalls(Collider collider) {
        for (Wall wall : map.getWalls()) {
            if (wall.getCollider().colision(collider))
                return true;
        }
        return false;
    }

    public void update(long deltatime) {
        pacmanMoving(deltatime);
        coinCollisions(deltatime);
        ghostPacmanCollisions(deltatime, red);
        ghostPacmanCollisions(deltatime, cyan);
        ghostPacmanCollisions(deltatime, pink);
        ghostPacmanCollisions(deltatime, orange);
        coinsGone(deltatime);
        map.getRed().update(deltatime);
        map.getOrange().update(deltatime);
        map.getPink().update(deltatime);
        map.getCyan().update(deltatime);

        // ver aqui se colide, diminuir vidas, e acabar se ele ficar com 0
   }

   private void coinsGone(long deltatime){
        if(map.getSmallCoins().isEmpty()&&map.getPowerCoins().isEmpty()){
            isRunning=false;
            lost=false;
        }
   }

   private void pacmanMoving(long deltatime){
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
   }

   private void coinCollisions(long deltatime){
        Pacman pacman = map.getPacman();
       wasSmallCoin = false;
       // Acho que assim é preferivel do que o o for nas 140 coins
       for(int i= -1; i <= 1; i++) {
           for (int j = -1; j <= 1; j++) {
               Position p = new Position((pacman.getPosition().getRow()) / 8 + i, (pacman.getPosition().getCol()) /12 + j);
               SmallCoin smallCoin = map.getSmallCoins().get(p);
               if (smallCoin != null) {
                   if (smallCoin.getCollider().colision(pacman.getCollider())) {
                       map.getSmallCoins().remove(p);
                       pacman.increaseScore(SmallCoin.SmallCoinValue);
                       wasSmallCoin = true;
                       break;
                   }
               }
           }
       }
       if (!wasSmallCoin){
           toRemove = new ArrayList<>();
           for (PowerCoin powerCoin : map.getPowerCoins()) {
               if (powerCoin.getCollider().colision(pacman.getCollider())) {
                   toRemove.add(powerCoin);
                   pacman.increaseScore(PowerCoin.PowerCoinValue);
                   red.setFrightenedModeOn();
                   map.setRed(red);
                   pink.setFrightenedModeOn();
                   map.setPink(pink);
                   cyan.setFrightenedModeOn();
                   map.setCyan(cyan);
                   orange.setFrightenedModeOn();
                   map.setOrange(orange);
                   break;
               }
           }
           map.getPowerCoins().removeAll(toRemove);
       }
   }

   private void ghostPacmanCollisions(long deltatime, Ghost ghost){
       if(pacman.getCollider().colision(ghost.getCollider())){
           if(ghost.getFrightenedModeOn()){
               pacman.increaseScore(ghost.getScore());
               ghost.updateScore();
               ghost.setPosition(ghost.getBeginPosition());
               ghost.setFrightenedModeOff();
           }
           else{
               lives--;
               if(lives==0){
                   lost=true;
                   isRunning=false;
               }
               red.setPosition(red.getBeginPosition());
               orange.setPosition(orange.getBeginPosition());
               pink.setPosition(pink.getBeginPosition());
               cyan.setPosition(cyan.getBeginPosition());
               pacman.setPosition(pacman.getBeginPosition());
               pacman.setDirection(Direction.Down);
           }
       }
   }

    public boolean isRunning(){         // TO CHANGE LATER
        return isRunning;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public boolean hasLost() {
        return lost;
    }
}
