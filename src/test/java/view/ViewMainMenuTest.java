package view;

import model.Menu.MainMenuModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ViewMainMenuTest {
    ViewMainMenu view;

    public void draw() throws IOException {
        view= Mockito.spy(new ViewMainMenu(new MainMenuModel()));
        view.initScreen();
        view.draw();
        view.draw();

    }
    @Test
    public void InsDrawTest() throws IOException {
        draw();
        verify(view, times(2)).draw();

    }
}
