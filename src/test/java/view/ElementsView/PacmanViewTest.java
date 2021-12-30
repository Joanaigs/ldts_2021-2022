package view.ElementsView;

import model.Elements.Pacman;
import model.GameModel;
import model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.ElementsView.Ghosts.CyanView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PacmanViewTest {
    PacmanView view;

    public void draw() throws Exception {
        CyanView.GameView game=new CyanView.GameView(new GameModel());
        PacmanView pacmanView=new PacmanView(new Pacman(new Position(1, 1)), game.getGraphics());
        view=Mockito.spy(pacmanView);
        view.draw();

    }
    @Test
    public void InsDrawTest() throws Exception {
        draw();
        verify(view, times(1)).draw();

    }
}
