package g0902.view.ElementsView.Ghosts;

import g0902.model.Elements.Ghosts.Types.Orange;
import g0902.model.GameModel;
import g0902.model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import g0902.view.ElementsView.GameView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class OrangeViewTest {
    OrangeView view;

    public void draw() throws Exception {
        GameView game= new GameView(new GameModel());
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
