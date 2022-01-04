package g0902.view;

import g0902.model.Menu.EndScreenModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ViewEndScreenTest {
    ViewEndScreen view;

    public void draw() throws IOException {
        view= Mockito.spy(new ViewEndScreen(new EndScreenModel()));
        view.initScreen();
        view.draw();
    }

    @Test
    public void InsDrawTest() throws IOException {
        draw();
        verify(view, times(2)).draw();

    }
}
