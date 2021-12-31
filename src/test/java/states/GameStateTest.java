package states;

import model.GameModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.ElementsView.GameView;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameStateTest {
    GameState state;
    public void step() throws Exception {
        state= Mockito.spy(new GameState(10));
        state.step();

    }
    @Test
    public void InsDrawTest() throws Exception {
        step();
        verify(state, times(1)).step();

    }
}
