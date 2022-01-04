package view.ElementsView;

import model.Elements.Coins.PowerCoin;
import model.GameModel;
import model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.ElementsView.Coins.PowerCoinView;
import view.ElementsView.Ghosts.CyanView;

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
