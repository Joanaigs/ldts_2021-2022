package g0902.view.ElementsView.Ghosts;

import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Constants;
import g0902.model.Elements.Direction;
import g0902.view.ElementsView.View;

import java.io.IOException;

public abstract class GhostView extends View {

    public GhostView(TextGraphics graphics) { super(graphics); }

    public String[]  setGhostDraw(Direction direction){
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
