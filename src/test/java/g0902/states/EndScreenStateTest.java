package g0902.states;


import g0902.view.ViewEndScreen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class EndScreenStateTest {
    ViewEndScreen view;
    EndScreenState state;
    @BeforeEach
    void setUp() throws IOException {
        view=mock(ViewEndScreen.class);
        state=new EndScreenState(view);
    }

    @Test
    public void InsDrawTest() throws IOException {
        state.step();
        Mockito.verify(view, times(1)).draw();
    }
}
