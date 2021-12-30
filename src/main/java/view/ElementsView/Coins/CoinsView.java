package view.ElementsView.Coins;

import com.googlecode.lanterna.graphics.TextGraphics;
import view.ElementsView.View;

public abstract class CoinsView extends View {

    public CoinsView(TextGraphics graphics) {
        super(graphics);
    }

    public abstract void draw();
}
