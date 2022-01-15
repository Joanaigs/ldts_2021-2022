package g0902.view.ElementsView.Ghosts;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Ghost;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Pink;

import java.io.IOException;

public class PinkView extends GhostView {
    private Pink pink;

    public PinkView(Ghost pink, TextGraphics graphics) {
        super(graphics);
        this.pink = (Pink) pink;
    }

    @Override
    public void draw() throws IOException {

        if (!pink.getFrightenedModeOn()) {
            String[] ghostDraw = setGhostDraw(pink.getCurrentDirection());   //Draw the ghost with the right shape

            int y = 0;
            for (String s : ghostDraw) {
                for (int x = 0; x < s.length(); x++) {
                    switch (s.charAt(x)) {
                        case '#' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#FFB8FF"));
                        case '0' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
                        case '1' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#2121DE"));
                        default  ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
                    }
                    graphics.fillRectangle(new TerminalPosition(pink.getPosition().getCol() + x * 2 + 2, pink.getPosition().getRow() + y +1),new TerminalSize(2, 1), ' ');
                }
                y++;
            }
        } else { FrightenedView frightenedView = new FrightenedView(pink, graphics);
                    frightenedView.draw();}
    }

}
