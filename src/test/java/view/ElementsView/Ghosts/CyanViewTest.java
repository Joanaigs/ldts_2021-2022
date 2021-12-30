package view.ElementsView.Ghosts;

import model.Elements.Ghosts.Cyan;
import model.Elements.Ghosts.Red;
import model.GameModel;
import model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.GameView;
import view.ElementsView.Ghosts.RedView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CyanViewTest {
    CyanView view;

    public void draw() throws Exception {
        GameView game=new GameView(new GameModel());
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
