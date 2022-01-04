package g0902.view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Elements.Wall;

public class WallView extends View {
    private Wall wall;

    public WallView(Wall wall, TextGraphics graphics){
        super(graphics);
        this.wall = wall;
    }

    @Override
    public void draw() {
        //00008b
        graphics.setBackgroundColor(TextColor.Factory.fromString("#181B70"));
        graphics.fillRectangle(new TerminalPosition(wall.getPosition().getCol(), wall.getPosition().getRow()),
                new TerminalSize(wall.getWidth(), wall.getHeight()), ' ');
    }
}
