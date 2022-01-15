package g0902.states;

import g0902.view.ElementsView.GameView;
import g0902.view.ViewRankingsMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class GameStateTest {
    GameState state;
    GameView view;
    @BeforeEach
    void setUp() throws IOException {
        view=mock(GameView.class);
        state=new GameState(view);
    }

    @Test
    public void InsDrawTest() throws IOException {
        state.step();
        Mockito.verify(view, times(1)).draw();
        Assertions.assertEquals(view, state.getViewer());
        Assertions.assertEquals(true, state.isRunning());
    }
}
