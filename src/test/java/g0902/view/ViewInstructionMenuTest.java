package g0902.view;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ViewInstructionMenuTest<T> {
    ViewInstructionMenu view;

    public void draw() throws IOException {
        view=mock(ViewInstructionMenu.class);
        doCallRealMethod().when(view).draw();
        doCallRealMethod().when(view).initScreen();
        view.initScreen();
        view.draw();

    }
    @Test
    public void InsDrawTest() throws IOException {
        draw();
        verify(view, times(1)).draw();

    }
}
