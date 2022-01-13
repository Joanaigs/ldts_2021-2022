package g0902.model.Game;

import g0902.model.Direction;
import g0902.model.Game.MapElements.Coins.PowerCoin;
import g0902.model.Game.MapElements.Coins.SmallCoin;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Ghost;
import g0902.model.Game.Map.Builders.MapBuilder;
import g0902.model.Game.Map.Builders.MapReader;
import g0902.model.Game.Map.Map;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import g0902.model.Model;
import g0902.model.Position;
import g0902.view.ElementsView.Collider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameModel implements Model {
    private final Map map;
    private final List<Ghost> ghosts;
    int score;
    Pacman pacman;
    int lives;
    boolean isRunning;
    boolean lost;

    public GameModel() throws IOException {
        MapBuilder mapBuilder = new MapReader();
        map = mapBuilder.createMap("map");
        ghosts = List.of(map.getRed(), map.getPink(), map.getCyan(), map.getOrange());
        pacman = map.getPacman();
        isRunning=true;
        lives=3;
        lost=false;
    }

    public Map getMap() {
        return map;
    }


    public void update(long deltatime) {

        pacman.update(deltatime);

        coinCollisions();
        for( Ghost ghost: ghosts)
            ghostPacmanCollisions(ghost);

        allCoinsEaten();

        for( Ghost ghost: ghosts)
            ghost.update(deltatime);
   }

   private void allCoinsEaten(){
        if(map.getSmallCoins().isEmpty()&&map.getPowerCoins().isEmpty()){
            isRunning=false;
            lost=false;
        }
   }

    private void coinCollisions(){
        if(!smallCoinCollisions())
            powerCoinCollisions();
    }

    private boolean smallCoinCollisions(){
        for(int i= -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                Position p = new Position((pacman.getPosition().getRow()) / 8 + i, (pacman.getPosition().getCol()) /12 + j);
                SmallCoin smallCoin = map.getSmallCoins().get(p);
                if (smallCoin != null) {
                    if (smallCoin.getCollider().collision(pacman.getCollider())) {
                        map.getSmallCoins().remove(p);
                        pacman.increaseScore(SmallCoin.SmallCoinValue);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void powerCoinCollisions(){
        ArrayList<PowerCoin> toRemove;
        toRemove = new ArrayList<>();
        for (PowerCoin powerCoin : map.getPowerCoins()) {
            if (powerCoin.getCollider().collision(pacman.getCollider())) {
                toRemove.add(powerCoin);
                pacman.increaseScore(PowerCoin.PowerCoinValue);
                for( Ghost ghost: ghosts)
                    ghost.setFrightenedModeOn();
                    break;
                }
            }
        map.getPowerCoins().removeAll(toRemove);
    }


   private void ghostPacmanCollisions(Ghost ghost){
       Collider ghostCollider = new Collider(ghost.getPosition(), 22, 7);
       Collider pacmanCollider = new Collider(pacman.getPosition(), 22, 7);
       if(ghostCollider.collision(pacmanCollider)){
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
               resetGame();
               }
           }
       }

    private void resetGame() {
        pacman.setCurrentDirection(Direction.Down);
        pacman.setPosition(pacman.getBeginPosition());

        for (Ghost g : ghosts) {
            g.setPosition(g.getBeginPosition());
            if (g.getFrightenedModeOn())
                g.setFrightenedModeOff();
        }
    }

    public boolean isRunning(){return isRunning;}

    public void setScore(int score) {this.score = score;}

    public int getScore() {return score;}

    public boolean hasLost() {return lost;}
}

