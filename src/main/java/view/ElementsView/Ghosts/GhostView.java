package view.ElementsView.Ghosts;

import com.googlecode.lanterna.graphics.TextGraphics;
import model.Elements.Ghosts.Ghost;
import view.ElementsView.View;

import java.io.IOException;

public abstract class GhostView extends View {

    public GhostView(TextGraphics graphics) { super(graphics); }

    // 14 de largura, e 11 de altura. O pacman tem 13 de largura e 11 de altura, entao estamos bem.
    public static final String[] right_Ghost= {
            "     ####",
            "   ########",
            "  #00####00#",
            " #0000##0000#",
            " #0011##0011#",
            " #0011##0011#",
            "##0011##0011##",
            "###00####00###",
            "##############",
            "## ###  ### ##",
            "#   ##  ##   #",
    };

    public static final String[] left_Ghost= {
            "     ####",
            "   ########",
            "  #00####00#",
            " #0000##0000#",
            " #1100##1100#",
            " #1100##1100#",
            "##1100##1100##",
            "###00####00###",
            "##############",
            "## ###  ### ##",
            "#   ##  ##   #",
    };

    public static final String[] up_Ghost= {
            "     ####",
            "   ########",
            "  #11####11#",
            " #1111##1111#",
            " #0110##0111#",
            " #0000##0000#",
            "##0000##0000##",
            "###00####00###",
            "##############",
            "## ###  ### ##",
            "#   ##  ##   #",
    };


    public static final String[] down_Ghost= {
            "     ####",
            "   ########",
            "  #00####00#",
            " #0000##0000#",
            " #0000##0000#",
            " #0110##0110#",
            "##1111##1111##",
            "###11####11###",
            "##############",
            "## ###  ### ##",
            "#   ##  ##   #",
    };


    @Override
    public abstract void draw() throws IOException;
}
