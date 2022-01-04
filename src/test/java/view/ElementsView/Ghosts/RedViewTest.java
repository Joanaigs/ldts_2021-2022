package view.ElementsView.Ghosts;

import model.Elements.Ghosts.Types.Red;
import model.GameModel;
import model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.ElementsView.GameView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RedViewTest {
    RedView view;

    public void draw() throws Exception {
        GameView game=new GameView(new GameModel());
        RedView redView =new RedView(new Red(new Position(1, 1)), game.getGraphics());
        view= Mockito.spy(redView);
        view.draw();

    }

    @Test
    public void InsDrawTest() throws Exception {
        draw();
        verify(view, times(1)).draw();

    }
}
