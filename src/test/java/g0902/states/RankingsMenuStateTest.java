package g0902.states;

import g0902.view.ViewMainMenu;
import g0902.view.ViewRankingsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class RankingsMenuStateTest {
    RankingsMenuState state;
    ViewRankingsMenu view;
    @BeforeEach
    void setUp() throws IOException {
        view=mock(ViewRankingsMenu.class);
        state=new RankingsMenuState(view);
    }

    @Test
    public void InsDrawTest() throws IOException {
        state.step();
        Mockito.verify(view, times(1)).draw();
    }
}
