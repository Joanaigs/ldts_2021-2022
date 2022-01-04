package g0902.view.ElementsView;

import g0902.model.Elements.Coins.PowerCoin;
import g0902.model.GameModel;
import g0902.model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import g0902.view.ElementsView.Coins.PowerCoinView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PowerCoinViewTest {
    PowerCoinView view;

    public void draw() throws Exception {
        GameView game=new GameView(new GameModel());
        PowerCoinView powerCoinView=new PowerCoinView(new PowerCoin(new Position(1, 1)), game.getGraphics());
        view= Mockito.spy(powerCoinView);
        view.draw();

    }
    @Test
    public void InsDrawTest() throws Exception {
        draw();
        verify(view, times(1)).draw();

    }
}
