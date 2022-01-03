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
    }
}
