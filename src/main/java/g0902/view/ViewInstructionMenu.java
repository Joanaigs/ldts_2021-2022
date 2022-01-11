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
        String s1 = "      _ ___ _     _ ___  _      _";
        String s2 = "||\\ ||_  | |_|| ||   | || ||\\ ||_ ";
        String s3 = "|| \\| _| | |\\ |_||_  | ||_|| \\| _|";
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffca18"));//yellow
        graphics.putString(10, 2, s1);
        graphics.putString(10, 3, s2);
        graphics.putString(10, 4, s3);
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
        graphics.setForegroundColor(TextColor.Factory.fromString("#08ecd9"));
        graphics.putString(1, 1, "<-BACK", SGR.BLINK);
        intructrionsDraw();
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        arrowsDraw();
        graphics.putString(5, 16, "The game goal in our version is that Pac-Man");
        graphics.putString(5, 17, "eats all the coins without being caught by the");
        graphics.putString(5, 18, "different ghosts.");
        graphics.putString(2, 20, "Run from the ghosts while they are trying to catch you!");
        screen.refresh();
    }
}
