package view.ElementsView;

import model.GameModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class GameViewTest {
    GameView view;

    public void draw() throws Exception {
        view= Mockito.spy(new GameView(new GameModel()));
        view.initScreen();
        view.draw();

    }
    @Test
    public void InsDrawTest() throws Exception {
        draw();
        verify(view, times(1)).initScreen();
        verify(view, times(1)).draw();

    }

}
