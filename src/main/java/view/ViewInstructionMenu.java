package view;

import com.googlecode.lanterna.TextColor;
import model.Menu.InstructMenuModel;

import java.io.IOException;

public class ViewInstructionMenu extends Viewer<InstructMenuModel> {

    public ViewInstructionMenu(InstructMenuModel model) {
        super(model);
    }

    @Override
    public void draw() throws IOException {
        String s1 = "      _ ___ _     _ ___  _      _";
        String s2 = "||\\ ||_  | |_|| ||   | || ||\\ ||_ ";
        String s3 = "|| \\| _| | |\\ |_||_  | ||_|| \\| _|";

        graphics.setForegroundColor(TextColor.Factory.fromString("#ffca18"));   //yellow
        graphics.putString(1, 2, s1);
        graphics.putString(2, 3, s2);
        graphics.putString(3, 4, s3);


    }
}
