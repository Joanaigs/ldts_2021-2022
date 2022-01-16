package g0902.view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.Draws;
import g0902.model.Game.MapElements.MovingElements.Pacman;


public class PacmanView extends View {

    private Pacman pacman;

    public PacmanView(Pacman pacman, TextGraphics graphics) {
        super(graphics);
        this.pacman = pacman;
    }

    public String[] setPacDraw(String[] pacDraw){
        if(pacman.isOpen()) {
            switch (pacman.getCurrentDirection()) {
                case Right -> pacDraw = Draws.PAC_OPEN_RIGHT;
                case Left -> pacDraw = Draws.PAC_OPEN_LEFT;
                case Up -> pacDraw = Draws.PAC_OPEN_UP;
                case Down -> pacDraw = Draws.PAC_OPEN_DOWN;
                case None -> pacDraw = Draws.PAC_CLOSE;
            }
        }
            else pacDraw = Draws.PAC_CLOSE;;
        return pacDraw;
    }

    @Override
    public void draw() {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#EECD40")); // set color to yellow
        String[] pacDraw = new String[0];
        pacDraw = setPacDraw(pacDraw);

        int y = 0;
        for (String s : pacDraw){
            for (int x = 0; x < s.length(); x++){
                if (s.charAt(x) == '#')
                    graphics.fillRectangle(new TerminalPosition(pacman.getPosition().getCol() + x *2 + 2 , pacman.getPosition().getRow() + y + 2),  new TerminalSize(2, 1), ' ');
            }
            y++;
        }
    }

}
