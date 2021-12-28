package view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import model.Model;

import java.awt.*;
import java.io.IOException;

public abstract class ViewerMenu<T extends Model> extends Viewer{

    ViewerMenu(T model){
        super(model);
    }
    @Override
    public void initScreen() {
        try {
            TerminalSize terminalSize = new TerminalSize(59, 29);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary();
            graphics=screen.newTextGraphics();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
