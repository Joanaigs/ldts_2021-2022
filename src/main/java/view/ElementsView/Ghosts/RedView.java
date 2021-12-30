package view.ElementsView.Ghosts;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.Elements.Ghosts.Ghost;
import model.Elements.Ghosts.Types.Red;
import view.ElementsView.View;

public class RedView extends View {
    private Red red;

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
            "## ###  ### ##",
            "#   ##  ##   #",
    };// 14 de largura, e 11 de altura. O pacman tem 13 de largura e 11 de altura, entao estamos bem.

    public RedView(Ghost red, TextGraphics graphics) {
        super(graphics);
        this.red = (Red) red;
    }

    @Override
    public void draw() {
        int y = 0;
        for (String s : normalGhost ){
            for (int x = 0; x < s.length(); x++){
                switch(s.charAt(x)){
                    case '#' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
                    case '0' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
                    case '1' ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#2121DE"));
                    default  ->  graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));

                }

                graphics.fillRectangle(new TerminalPosition(
                                red.getPosition().getCol() + x *2 + 1 , red.getPosition().getRow() + y -2),
                        new TerminalSize(2, 1), ' ');
            }
            y++;
        }
    }


}
