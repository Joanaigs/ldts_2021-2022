package g0902.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import g0902.Constants;
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

        graphics.putString(20, 7, s4);
        graphics.putString(20, 8, s5);
        graphics.putString(20, 9, s6);
        graphics.putString(20, 10, s7);
        graphics.putString(20, 11, s8);
        graphics.putString(20, 12, s9);
    }

    public void draw() throws IOException {
        graphics.setForegroundColor(TextColor.Factory.fromString(Constants.WHITE));
        graphics.putString(1, 1, "<-ESC", SGR.BLINK);
        graphics.setForegroundColor(TextColor.Factory.fromString(Constants.YELLOW));
        intructrionsDraw();
        graphics.setForegroundColor(TextColor.Factory.fromString(Constants.WHITE));
        arrowsDraw();
        graphics.putString(5, 16, "The game goal in our version is that Pac-Man");
        graphics.putString(5, 17, "eats all the coins without being caught by the");
        graphics.putString(5, 18, "different ghosts.");
        graphics.putString(2, 20, "Run from the ghosts while they are trying to catch you!");
        graphics.putString(2, 22, "To leave the instruction menu and leaderboard press esc.");
        graphics.putString(2, 23, "When the game is over you have to insert a 3 letter name");
        graphics.putString(2, 24, "and press enter.");
        graphics.putString(2, 25, "You can close de game at any moment by pressing x on the keyboard");
        graphics.putString(2, 26, "keyboard.");
        graphics.putString(2, 27, "You can leave the game mode by pressing enter.");
        screen.refresh();
    }
}
