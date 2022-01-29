package g0902.view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import g0902.model.Game.MapElements.Wall;
import g0902.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class WallViewTest {
    private TextGraphics tg;
    WallView view;
    @BeforeEach
    void setUp() {
        Position position=mock(Position.class);
        tg = mock(TextGraphics.class);
        view=new WallView(new Wall(position, 39, 39), tg);
        view.setGraphics(tg);
    }

    @Test
    public void InsDrawTest() {
        view.draw();
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(any());}
}
