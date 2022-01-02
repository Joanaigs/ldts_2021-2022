package view;

import model.Menu.MainMenuModel;
import model.Menu.RankingsMenuModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ViewRankingsMenuTest {
    ViewRankingsMenu view;

    public void draw() throws IOException {
        view= Mockito.spy(new ViewRankingsMenu(new RankingsMenuModel()));
        view.initScreen();
        view.draw();

    }
    @Test
    public void InsDrawTest() throws IOException {
        draw();
        verify(view, times(1)).draw();

    }
}
