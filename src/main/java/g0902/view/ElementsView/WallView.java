package g0902.view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.view.Constants;
import g0902.model.Game.MapElements.Wall;

public class WallView extends View {
    private final Wall wall;

    public WallView(Wall wall, TextGraphics graphics){
        super(graphics);
        this.wall = wall;
    }

    @Override
    public void draw() {
        //00008b
        graphics.setBackgroundColor(TextColor.Factory.fromString(Constants.WALLS));
        graphics.fillRectangle(new TerminalPosition(wall.getPosition().getCol(), wall.getPosition().getRow()),
                new TerminalSize(wall.getWidth(), wall.getHeight()), ' ');
    }
}
