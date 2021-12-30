package view.ElementsView.Ghosts;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Orange;
import model.Elements.Ghosts.Pink;
import view.ElementsView.View;

public class OrangeView extends View {
    private Orange orange;

    public static final String[] normalGhost= {
            "     ####",
            "   ########",
            "  #00####00#",
            " #0000##0000#",
            " #0110##0110#",
            " #0110##0110#",
            "##0110##0110##",
            "###00####00###",
            "##############",
            "##############",
            "## ###  ### ##",
            "#   ##  ##   #",
    };

    public OrangeView(Ghost orange, TextGraphics graphics) {
        super(graphics);
        this.orange = (Orange) orange;
    }

    @Override
    public void draw() {
        int y = 0;
        for (String s : normalGhost ){
            for (int x = 0; x < s.length(); x++){
                switch(s.charAt(x)){
                    case '#' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#FFB852"));
                    case '0' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
                    case '1' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#2121DE"));
                    default  ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));

                }

                graphics.fillRectangle(new TerminalPosition(
                                orange.getPosition().getCol() + x *2 + 1 , orange.getPosition().getRow() + y -2),
                        new TerminalSize(2, 1), ' ');
            }
            y++;
        }
    }


}
