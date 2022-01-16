package g0902.view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class LivesViewTest extends Assertions {
    TextGraphics textGraphics;
    Pacman pacman;
    LivesView livesView;

    @BeforeEach
    void create(){
        textGraphics = Mockito.mock(TextGraphics.class);
        pacman = Mockito.mock(Pacman.class);
        livesView = Mockito.spy(new LivesView(pacman, textGraphics));
    }

    @Test
    void draw() throws IOException {
        Mockito.when(pacman.getLives()).thenReturn(3);
        livesView.draw();
        Mockito.verify(livesView, Mockito.times(3)).drawPacman(Mockito.any());
        Mockito.when(pacman.getLives()).thenReturn(2);
        livesView.draw();
        Mockito.verify(livesView, Mockito.times(5)).drawPacman(Mockito.any());
    }
}
