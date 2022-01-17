package g0902.view.ElementsView.Ghosts;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.Constants;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Ghost;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Red;

import java.io.IOException;

public class RedView extends GhostView {
    private Red red;

    public RedView(Ghost red, TextGraphics graphics) {
        super(graphics);
        this.red = (Red) red;
    }

    @Override
    public void draw() throws IOException {
        if (!red.getFrightenedModeOn()) {
            String[] ghostDraw = setGhostDraw(red.getCurrentDirection());   //Draw the ghost with the right shape

            int y = 0;
            for (String s : ghostDraw) {
                for (int x = 0; x < s.length(); x++) {
                    switch (s.charAt(x)) {
                        case '#' ->  graphics.setBackgroundColor(TextColor.Factory.fromString(Constants.RED));
                        case '0' -> graphics.setBackgroundColor(TextColor.Factory.fromString(Constants.WHITE));
                        case '1' -> graphics.setBackgroundColor(TextColor.Factory.fromString(Constants.DARK_BLUE));
                        default -> graphics.setBackgroundColor(TextColor.Factory.fromString(Constants.BLACK));

                    }

                    graphics.fillRectangle(new TerminalPosition(red.getPosition().getCol() + x * 2 + 1, red.getPosition().getRow() + y +2), new TerminalSize(2, 1), ' ');
                }
                y++;
            }
        } else {
            FrightenedView frightenedView = new FrightenedView(red, graphics);
            frightenedView.draw();
        }
    }
}
