package g0902.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.TerminalEmulatorAutoCloseTrigger;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class LanternaGUI {
    Screen screen;
    protected TextGraphics graphics;

    public void createScreenGame(){
        try {
            Font font = new Font(Font.MONOSPACED, Font.PLAIN, 2);
            AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);
            Terminal terminal = new DefaultTerminalFactory()
                    .setInitialTerminalSize(new TerminalSize(469, 350))
                    .setTerminalEmulatorFontConfiguration(cfg)
                    .createTerminal();

            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // We don't need a cursor
            screen.startScreen();             // Screens must be started
            screen.doResizeIfNecessary();     // Resize screen if necessary
            screen.clear();
            graphics=screen.newTextGraphics();

        } catch (IOException e) {
            e.printStackTrace();
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeScreen() throws IOException {
        screen.close();
    }

    public Screen getScreen() {
        return screen;
    }

}
