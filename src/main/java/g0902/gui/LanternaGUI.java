package g0902.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.TerminalEmulatorAutoCloseTrigger;
import g0902.view.Constants;

import java.awt.*;

import java.io.IOException;

public class LanternaGUI {
    Screen screen;
    protected TextGraphics graphics;

    public void createScreenGame(){
        try {
            Font font = new Font(Font.MONOSPACED, Font.PLAIN, 2);
            AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);
            Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(Constants.GAME_SCREEN_WIDTH, Constants.GAME_SCREEN_HEIGHT)).setTerminalEmulatorFontConfiguration(cfg).createTerminal();

            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);   // We don't need a cursor
            screen.startScreen();             // Screens must be started
            screen.doResizeIfNecessary();     // Resize screen if necessary
            screen.clear();
            graphics=screen.newTextGraphics();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    public void createScreenMenu(){
        try {
            TerminalSize terminalSize = new TerminalSize(59, 29);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            terminalFactory.setTerminalEmulatorFrameAutoCloseTrigger(TerminalEmulatorAutoCloseTrigger.CloseOnExitPrivateMode);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary();
            graphics=screen.newTextGraphics();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }


    public Screen getScreen() {
        return screen;
    }

}
