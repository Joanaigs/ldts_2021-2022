package view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.Elements.Wall;

public class WallView extends View {
    private Wall wall;

    public WallView(Wall wall, TextGraphics graphics){
        super(graphics);
        this.wall = wall;
    }

    @Override
    public void draw() {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#00008b"));
        graphics.fillRectangle(new TerminalPosition(wall.getPosition().getCol(), wall.getPosition().getRow()),
                new TerminalSize(wall.getWidth(), wall.getHeight()), ' ');
    }
}
