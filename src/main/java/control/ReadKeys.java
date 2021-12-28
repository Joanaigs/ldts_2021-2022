package control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import model.GameModel;

import javax.swing.*;
import java.io.IOException;

public class ReadKeys implements Runnable {
    Screen screen;
    GameModel gameModel;
    PacmanController pacmanController;
    public ReadKeys(Screen screen, GameModel gameModel){
        this.screen = screen;
        this.gameModel=gameModel;
        pacmanController = new PacmanController(gameModel.getMap().getPacman());
    }

    public void run() {
        try {
            while (true) {
                KeyStroke keyStroke = screen.readInput();
                System.out.println(keyStroke);
                pacmanController.processKey(keyStroke);
                //Thread.sleep(100);

            }
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }
}
