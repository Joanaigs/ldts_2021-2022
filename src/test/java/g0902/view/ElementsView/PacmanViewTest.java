package g0902.view.ElementsView;

import g0902.model.Elements.Pacman;
import g0902.model.GameModel;
import g0902.model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PacmanViewTest {
    PacmanView view;

    public void draw() throws Exception {
        GameView game=new GameView(new GameModel());
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
