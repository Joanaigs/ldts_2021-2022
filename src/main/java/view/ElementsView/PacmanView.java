package view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.Elements.Pacman;

public class PacmanView extends View {

    private Pacman pacman;
    private static final String[] pac_open = {

            "     #####",
            "   #########",
            "  ##### #####",
            "  #########",
            " #######",
            " ####",
            " #######",
            "  #########",
            "  ###########",
            "   #########",
            "     #####"};

    private static final String[] pac_close = {

            "     #####",
            "    ########",
            "   ##### ####",
            "  ###########",
            " #############",
            " #############",
            " #############",
            " #############",
            "  ###########",
            "   #########",
            "     #####"};


    public PacmanView(Pacman pacman, TextGraphics graphics) {
        super(graphics);
        this.pacman = pacman;
    }

    @Override
    public void draw() {
        // set color to yellow
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFF00"));

        int y = 0;
        // draw pacman, square by square
        String[] pacDraw;
        if( pacman.isOpen())
            pacDraw = pac_open;
        else
            pacDraw = pac_close;

        for (String s : pacDraw ){
            for (int x = 0; x < s.length(); x++){
                if (s.charAt(x) == '#')
                    graphics.fillRectangle(new TerminalPosition(
                                    pacman.getPosition().getCol() + x *2 + 2 , pacman.getPosition().getRow() + y + 2),
                            new TerminalSize(2, 1), ' ');
            }
            y++;
        }
    }


}
