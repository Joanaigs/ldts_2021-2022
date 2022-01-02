package view.ElementsView.Ghosts;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Types.Pink;
import view.ElementsView.View;

import java.io.IOException;

public class PinkView extends GhostView {
    private Pink pink;

    public PinkView(Ghost pink, TextGraphics graphics) {
        super(graphics);
        this.pink = (Pink) pink;
    }

    @Override
    public void draw() throws IOException {
        String[] ghostDraw = new String[0];

        if (!pink.getFrightenedModeOn()) {

            switch (pink.getCurrentDirection()) {
                case Right:
                    ghostDraw = right_Ghost;
                    break;
                case Left:
                    ghostDraw = left_Ghost;
                    break;
                case Up:
                    ghostDraw = up_Ghost;
                    break;
                case Down:
                    ghostDraw = down_Ghost;
                    break;
                case None:
                    break;
            }

            int y = 0;
            for (String s : ghostDraw) {
                for (int x = 0; x < s.length(); x++) {
                    switch (s.charAt(x)) {
                        case '#' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#FFB8FF"));
                        case '0' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
                        case '1' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#2121DE"));
                        default  ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));

                    }

                    graphics.fillRectangle(new TerminalPosition(
                                    pink.getPosition().getCol() + x * 2 + 1, pink.getPosition().getRow() + y - 2),
                            new TerminalSize(2, 1), ' ');
                }
                y++;
            }
        } else {
            FrightenedView frightenedView = new FrightenedView(pink, graphics);
            frightenedView.draw();
        }
    }

}
