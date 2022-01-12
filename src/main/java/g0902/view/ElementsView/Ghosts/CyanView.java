package g0902.view.ElementsView.Ghosts;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Game.MapElements.Ghosts.Types.Cyan;
import g0902.model.Game.MapElements.Ghosts.Ghost;

import java.io.IOException;

public class CyanView extends GhostView{
    private Cyan cyan;

    public CyanView(Ghost cyan, TextGraphics graphics) {
        super(graphics);
        this.cyan = (Cyan) cyan;
    }

    @Override
    public void draw() throws IOException {

        if (!cyan.getFrightenedModeOn()) {
            String[] ghostDraw = setGhostDraw(cyan.getCurrentDirection());   //Draw the ghost with the right shape

            int y = 0;
            for (String s : ghostDraw) {
                for (int x = 0; x < s.length(); x++) {
                    switch (s.charAt(x)) {
                        case '#' -> graphics.setBackgroundColor(TextColor.Factory.fromString("#00FFFF"));
                        case '0' -> graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
                        case '1' -> graphics.setBackgroundColor(TextColor.Factory.fromString("#2121DE"));
                        default -> graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));

                    }

                    graphics.fillRectangle(new TerminalPosition(cyan.getPosition().getCol() + x * 2 + 1, cyan.getPosition().getRow() + y +1), new TerminalSize(2, 1), ' ');
                }
                y++;
            }
        } else {
            FrightenedView frightenedView = new FrightenedView(cyan, graphics);
            frightenedView.draw();
        }
    }

}
