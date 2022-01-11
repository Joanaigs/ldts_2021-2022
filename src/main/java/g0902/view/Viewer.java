package g0902.view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import g0902.model.Model;

import java.awt.*;
import java.io.IOException;

public abstract class Viewer<T extends Model> {
    protected T model;
    protected Screen screen;
    protected TextGraphics graphics;

    public Viewer(T model, Screen gui){
        this.model=model;
        this.screen=gui;
        graphics=screen.newTextGraphics();
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

    public void setModel(T model) {
        this.model = model;
    }

}