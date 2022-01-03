package states;

import model.Menu.EndScreenModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class EndScreenStateTest {
    EndScreenState state;
    public void step() throws Exception {
        state= Mockito.mock(EndScreenState.class);
        state.step();

    }
    @Test
    public void InsDrawTest() throws Exception {
        step();
        verify(state, times(1)).step();

    }
}