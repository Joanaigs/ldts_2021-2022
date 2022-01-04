package g0902.model.Menu;

import g0902.model.Model;

public class EndScreenModel implements MenuModel, Model {

    private boolean running;
    String name;
    int score;
    boolean lost;

    public EndScreenModel(){
        running=true;
        name="___";
        lost=false;
    }
    @Override
    public void setRunning(boolean running) {
        this.running=running;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    public void addLetter(char letter){
        StringBuilder newName = new StringBuilder(name);
        for(int i=0; i<name.length(); i++){
            if(name.charAt(i)=='_') {
                newName.setCharAt(i, letter);
                break;
            }
        }
        name= String.valueOf(newName);

    }

    public String getName() {
        return name;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public boolean hasLost() {
        return lost;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
