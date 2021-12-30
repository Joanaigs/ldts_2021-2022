package view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.Elements.Pacman;


public class PacmanView extends View {

    private Pacman pacman;
    private static final String[] pac_open_right = {

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
            "   #########",
            "  #### ######",
            "  #### ######",
            " #############",
            " #############",
            " #############",
            " #############",
            "  ###########",
            "   #########",
            "     #####"};

    private static final String[] pac_open_left = {

            "     #####",
            "   #########",
            "  ##### #####",
            "    #########",
            "       #######",
            "         ####",
            "       #######",
            "    #########",
            "  ###########",
            "   #########",
            "     #####"};


    private static final String[] pac_open_up = {

            "   #       #",
            "  ###     ###",
            " #####   #####",
            "####### #######",
            "### ###########",
            "###############",
            "##############",
            " ############",
            "  ##########",
            "   ########",
            "    ######"};


    private static final String[] pac_open_down = {

            "    ######",
            "   ########",
            " ############",
            "###############",
            "###############",
            "###############",
            "########### ###",
            "####### ######",
            " #####   #####",
            "  ###     ###",
            "   #       #"};



    public PacmanView(Pacman pacman, TextGraphics graphics) {
        super(graphics);
        this.pacman = pacman;
    }

    @Override
    public void draw() {
        // set color to yellow
        // era FFFF00
        graphics.setBackgroundColor(TextColor.Factory.fromString("#EECD40"));

        int y = 0;
        // draw pacman, square by square
        String[] pacDraw = new String[0];

        if( pacman.isOpen()){
            switch (pacman.getCurrentDirection()){
                case Right:
                    pacDraw = pac_open_right;
                    break;
                case Left:
                    pacDraw = pac_open_left;
                    break;
                case Up:
                    pacDraw = pac_open_up;
                    break;
                case Down:
                    pacDraw = pac_open_down;
                    break;
                case None:
                    pacDraw = pac_close;
                    break;
            }
        }

        else{
                    pacDraw = pac_close;
            }

        for (String s : pacDraw){
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
