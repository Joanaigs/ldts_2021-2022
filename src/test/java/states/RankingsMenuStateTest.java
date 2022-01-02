package states;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class RankingsMenuStateTest {
    RankingsMenuState state;
    public void step() throws Exception {
        state= mock(RankingsMenuState.class);
        state.step();

    }
    @Test
    public void InsDrawTest() throws Exception {
        step();
        verify(state, times(1)).step();

    }
}
