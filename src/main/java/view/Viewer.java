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

public abstract class Viewer<T extends Model> {
    protected T model;
    protected Screen screen;
    protected TextGraphics graphics;

    public Viewer(T model){
        initScreen();
        this.model=model;
    }
    public void initScreen() {
        try {
            Font font = new Font(Font.MONOSPACED, Font.PLAIN, 2);
            AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);
            Terminal terminal = new DefaultTerminalFactory()
                    .setInitialTerminalSize(new TerminalSize(469, 350))
                    .setTerminalEmulatorFontConfiguration(cfg)
                    .createTerminal();

            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // We don't need a cursor
            screen.startScreen();             // Screens must be started
            screen.doResizeIfNecessary();     // Resize screen if necessary
            screen.clear();
            graphics=screen.newTextGraphics();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void draw() throws IOException;

    public void setGraphics(TextGraphics graphics) {
        this.graphics = graphics;
    }

    public Screen getScreen() {
        return screen;
    }

    public T getModel() {
        return model;
    }

    public void closeScreen() throws IOException {screen.close();}

    public TextGraphics getGraphics() {
        return graphics;
    }
}