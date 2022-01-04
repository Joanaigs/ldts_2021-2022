package g0902.view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public abstract class View {
    protected TextGraphics graphics;

    public View(TextGraphics graphics){
        this.graphics = graphics;
    }

    public abstract void draw() throws IOException;

    public void setGraphics(TextGraphics graphics) {
        this.graphics = graphics;
    }
}
