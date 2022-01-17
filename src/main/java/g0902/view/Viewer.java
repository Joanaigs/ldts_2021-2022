package g0902.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import g0902.model.Model;

import java.io.IOException;

public abstract class Viewer<T extends Model> {
    protected T model;
    protected final Screen screen;
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