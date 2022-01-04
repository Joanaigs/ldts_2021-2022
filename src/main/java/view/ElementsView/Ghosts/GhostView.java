package view.ElementsView.Ghosts;

import com.googlecode.lanterna.graphics.TextGraphics;
import model.Constants;
import model.Elements.Direction;
import model.Elements.Ghosts.Ghost;
import view.ElementsView.View;

import java.io.IOException;

public abstract class GhostView extends View {

    public GhostView(TextGraphics graphics) { super(graphics); }

    protected String[]  setGhostDraw(Direction direction){
        String[] ghostDraw = new String[0];
        switch (direction) {
            case Right -> ghostDraw = Constants.RIGHT_GHOST;
            case Left  -> ghostDraw = Constants.LEFT_GHOST;
            case Up    -> ghostDraw = Constants.UP_GHOST;
            case Down  -> ghostDraw = Constants.DOWN_GHOST;
        }
        return ghostDraw;
    }

    @Override
    public abstract void draw() throws IOException;

}
