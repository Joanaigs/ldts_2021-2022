package g0902.view.ElementsView.Ghosts;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.Draws;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Ghost;

import java.io.IOException;

public class FrightenedView extends GhostView {
    private Ghost ghost;


    public FrightenedView(Ghost ghost, TextGraphics graphics) {
        super(graphics);
        this.ghost = ghost;
    }

    @Override
    public void draw() throws IOException {
        int y = 0;
        for (String s : Draws.FRIGHTENED_GHOST) {
            for (int x = 0; x < s.length(); x++) {
                switch (s.charAt(x)) {
                    case '#' -> graphics.setBackgroundColor(TextColor.Factory.fromString("#2121DE"));
                    case '1' -> graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
                    default -> graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));

                }
                graphics.fillRectangle(new TerminalPosition(ghost.getPosition().getCol() + x * 2 + 1, ghost.getPosition().getRow() + y +1), new TerminalSize(2, 1), ' ');
            }
            y++;
        }
    }
}
