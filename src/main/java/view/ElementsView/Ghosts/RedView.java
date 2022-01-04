package view.ElementsView.Ghosts;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Types.Red;
import view.ElementsView.View;

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
                        case '#' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
                        case '0' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
                        case '1' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#2121DE"));
                        default  ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));

                    }

                    graphics.fillRectangle(new TerminalPosition(red.getPosition().getCol() + x * 2 + 1, red.getPosition().getRow() + y +1), new TerminalSize(2, 1), ' ');
                }
                y++;
            }
        } else {
            FrightenedView frightenedView = new FrightenedView(red, graphics);
            frightenedView.draw();
        }
    }
}
