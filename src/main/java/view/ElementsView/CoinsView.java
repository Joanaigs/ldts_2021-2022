package view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class CoinsView extends View{

    public CoinsView(TextGraphics graphics) {
        super(graphics);
    }

    public abstract void draw();
}
