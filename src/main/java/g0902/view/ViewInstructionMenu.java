package g0902.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import g0902.model.Menu.InstructionMenuModel;

import java.io.IOException;

public class ViewInstructionMenu extends Viewer {

    public ViewInstructionMenu(InstructionMenuModel model, Screen screen) {
        super(model, screen);
    }

    public void intructrionsDraw(){
        String s1 = " _         _               _   _             ";
        String s2 = "| |___ ___| |_ ___ _ _ ___| |_|_|___ ___ ___ ";
        String s3 = "| |   |_ -|  _|  _| | |  _|  _| | . |   |_ -|";
        String s4 = "|_|_|_|___|_| |_| |___|___|_| |_|___|_|_|___|";
        graphics.setForegroundColor(TextColor.Factory.fromString(Constants.YELLOW));//yellow
        graphics.putString(6, 2, s1);
        graphics.putString(6, 3, s2);
        graphics.putString(6, 4, s3);
        graphics.putString(6, 5, s4);
    }

    public void arrowsDraw(){
        String s4 = "      ___      ";
        String s5 = "     | ^ |     ";
        String s6 = "     |_|_|     ";
        String s7 = " ___  ___  ___ ";
        String s8 = "| <-|| | ||-> |";
        String s9 = "|___||_v_||___|";

        graphics.putString(20, 17, s4);
        graphics.putString(20, 18, s5);
        graphics.putString(20, 19, s6);
        graphics.putString(20, 20, s7);
        graphics.putString(20, 21, s8);
        graphics.putString(20, 22, s9);
    }

    @Override
    public void draw() throws IOException {
        graphics.setForegroundColor(TextColor.Factory.fromString(Constants.WHITE));
        graphics.putString(1, 1, "<-ESC", SGR.BLINK);
        graphics.setForegroundColor(TextColor.Factory.fromString(Constants.YELLOW));
        intructrionsDraw();
        graphics.setForegroundColor(TextColor.Factory.fromString(Constants.WHITE));
        graphics.putString(5, 8, "The game goal in our version is that Pac-Man");
        graphics.putString(5, 9, "eats all the coins without being caught by the");
        graphics.putString(5, 10, "different ghosts.");
        graphics.putString(3, 13, "          MOVES                ARROWS");
        graphics.putString(3, 14, "        LEAVE GAME             ENTER ");
        graphics.putString(3, 15, "     CLOSE GAME WINDOW          'X'  ");
        graphics.putString(5, 27, "You can press ESC to go back to the Main Menu");
        arrowsDraw();
        screen.refresh();
    }
}
