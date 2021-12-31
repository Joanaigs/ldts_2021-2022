package states;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.mockito.Mockito.*;

public class InstructionMenuStateTest {
    InstructionMenuState state;
    public void step() throws Exception {
        state= Mockito.spy(new InstructionMenuState());
        state.step();

    }
    @Test
    public void InsDrawTest() throws Exception {
        step();
        verify(state, times(1)).step();

    }
}
