package view.ElementsView.Ghosts;

import model.Elements.Ghosts.Orange;
import model.GameModel;
import model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class OrangeViewTest {
    OrangeView view;

    public void draw() throws Exception {
        CyanView.GameView game=new CyanView.GameView(new GameModel());
        OrangeView orangeView =new OrangeView(new Orange(new Position(1, 1)), game.getGraphics());
        view= Mockito.spy(orangeView);
        view.draw();

    }

    @Test
    public void InsDrawTest() throws Exception {
        draw();
        verify(view, times(1)).draw();

    }
}
