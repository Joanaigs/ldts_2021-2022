package g0902.states;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class GameStateTest {
    GameState state;
    public void step() throws Exception {
        state= Mockito.spy(new GameState());
        state.step();

    }
    @Test
    public void InsDrawTest() throws Exception {
        step();
        verify(state, times(1)).step();

    }
}
