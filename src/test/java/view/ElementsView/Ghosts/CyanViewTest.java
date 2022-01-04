package view.ElementsView.Ghosts;

import model.Elements.Ghosts.Types.Cyan;
import model.GameModel;
import model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.ElementsView.GameView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CyanViewTest {
    CyanView view;

    public void draw() throws Exception {
        GameView game= new GameView(new GameModel());
        CyanView cyanView =new CyanView(new Cyan(new Position(1, 1)), game.getGraphics());
        view= Mockito.spy(cyanView);
        view.draw();

    }

    @Test
    public void InsDrawTest() throws Exception {
        draw();
        verify(view, times(1)).draw();

    }
}
