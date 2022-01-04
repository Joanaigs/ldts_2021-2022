package g0902.view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import g0902.model.Model;

import java.io.IOException;

public abstract class ViewerMenu<T extends Model> extends Viewer{

    ViewerMenu(T model){
        super(model);
    }

    ViewerMenu(T model, Screen screen){super(model, screen);}
    @Override
    public void initScreen() {
        try {
            TerminalSize terminalSize = new TerminalSize(59, 29);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary();
            graphics=screen.newTextGraphics();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
