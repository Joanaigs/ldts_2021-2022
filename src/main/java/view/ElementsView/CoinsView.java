package view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.Elements.Coins;

import java.util.List;

public abstract class CoinsView extends View{

    public CoinsView(TextGraphics graphics) {
        super(graphics);
    }

    public abstract void draw();
}
