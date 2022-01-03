package model.Menu;

import control.InstructionMenuController;
import model.Model;
import view.ViewInstructionMenu;

import java.nio.charset.StandardCharsets;

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
