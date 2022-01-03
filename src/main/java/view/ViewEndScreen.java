package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import model.Menu.EndScreenModel;
import model.Model;

import java.io.IOException;

public class ViewEndScreen extends ViewerMenu<EndScreenModel>{
    EndScreenModel endScreenModel;
    public ViewEndScreen(EndScreenModel endScreenModel) {
        super(endScreenModel);
        this.endScreenModel=endScreenModel;
    }

    @Override
    public void draw() throws IOException {
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffca18"));
        if(endScreenModel.hasLost()){
           String s1=" _____ ____  _      _____   ____  _     _____ ____ ";
           String s2="/  __//  _ \\/ \\__/|/  __/  /  _ \\/ \\ |\\/  __//  __\\";
           String s3="| |  _| / \\|| |\\/|||  \\    | / \\|| | //|  \\  |  \\/|";
           String s4="| |_//| |-||| |  |||  /_   | \\_/|| \\// |  /_ |    /";
           String s5="\\____\\\\_/ \\|\\_/  \\|\\____\\  \\____/\\__/  \\____\\\\_/\\_\\";

            graphics.putString(4, 2, s1, SGR.BOLD, SGR.BLINK);
            graphics.putString(4, 3, s2, SGR.BOLD, SGR.BLINK);
            graphics.putString(4, 4, s3,  SGR.BOLD, SGR.BLINK);
            graphics.putString(4, 5, s4,  SGR.BOLD, SGR.BLINK);
            graphics.putString(4, 6, s5,  SGR.BOLD, SGR.BLINK);
        }
        else{
            String s1=" __     __                    _       ";
            String s2=" \\ \\   / /                   (_)      ";
            String s3="  \\ \\_/ /__  _   _  __      ___ _ __  ";
            String s4="   \\   / _ \\| | | | \\ \\ /\\ / / | '_ \\ ";
            String s5="    | | (_) | |_| |  \\ V  V /| | | | |";
            String s6="    |_|\\___/ \\__,_|   \\_/\\_/ |_|_| |_|";

            graphics.putString(10, 2, s1, SGR.BOLD, SGR.BLINK);
            graphics.putString(10, 3, s2, SGR.BOLD, SGR.BLINK);
            graphics.putString(10, 4, s3,  SGR.BOLD, SGR.BLINK);
            graphics.putString(10, 5, s4,  SGR.BOLD, SGR.BLINK);
            graphics.putString(10, 6, s5,  SGR.BOLD, SGR.BLINK);
            graphics.putString(10, 7, s6,  SGR.BOLD, SGR.BLINK);
        }
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        String s1="   ___                                   ";
        String s2="  / __|    __      ___      _ _    ___   ";
        String s3="  \\__ \\   / _|    / _ \\    | '_|  / -_)  ";
        String s4="  |___/   \\__|_   \\___/   _|_|_   \\___|  ";
        String s5="_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"| ";
        String s6="\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-' ";

        graphics.putString(1, 10, s1, SGR.BOLD);
        graphics.putString(1, 11, s2, SGR.BOLD);
        graphics.putString(1, 12, s3,  SGR.BOLD);
        graphics.putString(1, 13, s4,  SGR.BOLD);
        graphics.putString(1, 14, s5,  SGR.BOLD);
        graphics.putString(1, 15, s6,  SGR.BOLD);

        graphics.putString(44, 14, String.valueOf(endScreenModel.getScore()), SGR.BOLD);

        String s7="  _  _                           ";
        String s8=" | \\| |   __ _    _ __     ___   ";
        String s9=" | .` |  / _` |  | '  \\   / -_)  ";
        String s10=" |_|\\_|  \\__,_|  |_|_|_|  \\___|  ";
        String s11="_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"| ";
        String s12="\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-' ";

        graphics.putString(1, 17, s7, SGR.BOLD);
        graphics.putString(1, 18, s8, SGR.BOLD);
        graphics.putString(1, 19, s9,  SGR.BOLD);
        graphics.putString(1, 20, s10,  SGR.BOLD);
        graphics.putString(1, 21, s11,  SGR.BOLD);
        graphics.putString(1, 22, s12,  SGR.BOLD);

        String s=endScreenModel.getName();
        graphics.putString(35, 20,s, SGR.BOLD);

        graphics.setForegroundColor(TextColor.Factory.fromString("#08ecd9"));
        String s13=" ____  ____  _      _____  _  _      _     _____";
        String s14="/   _\\/  _ \\/ \\  /|/__ __\\/ \\/ \\  /|/ \\ /\\/  __/";
        String s15="|  /  | / \\|| |\\ ||  / \\  | || |\\ ||| | |||  \\  ";
        String s16="|  \\__| \\_/|| | \\||  | |  | || | \\||| \\_/||  /_ ";
        String s17="\\____/\\____/\\_/  \\|  \\_/  \\_/\\_/  \\|\\____/\\____\\";

        graphics.putString(5, 23, s13, SGR.BOLD, SGR.BLINK);
        graphics.putString(5, 24, s14, SGR.BOLD, SGR.BLINK);
        graphics.putString(5, 25, s15,  SGR.BOLD, SGR.BLINK);
        graphics.putString(5, 26, s16,  SGR.BOLD, SGR.BLINK);
        graphics.putString(5, 27, s17,  SGR.BOLD, SGR.BLINK);
        screen.refresh();
    }
}
