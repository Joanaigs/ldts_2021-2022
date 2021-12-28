package control;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import model.Elements.Wall;
import model.GameModel;
import model.Maps.Builders.MapBuilder;
import model.Maps.Builders.MapReader;
import model.Maps.Map;
import view.ElementsView.GameView;

import java.awt.*;
import java.io.IOException;

public class Controller {
    GameModel gameModel;
    GameView gameView;
    Thread readKeys;

    public Controller() throws IOException {
        gameModel = new GameModel();
        gameView = new GameView(gameModel);
        readKeys =  new Thread(new ReadKeys(gameView.getScreen(), gameModel));
    }

    public void run() throws IOException, InterruptedException {
        readKeys.start();
        long pastTime = System.currentTimeMillis();     // para poder ter o tempo de frame em frame
        while(true){
            long now = System.currentTimeMillis();
            gameModel.update(now-pastTime);
            gameView.draw();
            pastTime = now;
        }
        //readKeys.interrupt();
    }

}
