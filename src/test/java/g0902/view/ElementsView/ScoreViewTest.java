package g0902.view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.model.Game.GameModel;
import g0902.model.Game.Map.Map;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class ScoreViewTest extends Assertions {
    TextGraphics textGraphics;
    GameModel gameModel;
    Map map;
    Pacman pac;
    ScoreView scoreView;


    @BeforeEach
    void create(){
        textGraphics = Mockito.mock(TextGraphics.class);
        gameModel = Mockito.mock(GameModel.class);
        map = Mockito.mock(Map.class);
        pac = Mockito.mock(Pacman.class);
        Mockito.when(gameModel.getMap()).thenReturn(map);
        Mockito.when(map.getPacman()).thenReturn(pac);
        scoreView = Mockito.spy(new ScoreView(gameModel, textGraphics));
    }

    @Test
    void draw() throws IOException {
        Mockito.when(pac.getScore()).thenReturn(10);
        Mockito.when(map.getHeight()).thenReturn(4);
        //when
        scoreView.draw();
        //then
        Mockito.verify(scoreView, Mockito.times(1)).drawScore();
        Mockito.verify(scoreView, Mockito.times(1)).drawNumber(0, 4+6, 97);
        Mockito.verify(scoreView, Mockito.times(1)).drawNumber(0, 4+6, 97+7*2+3);
        Mockito.verify(scoreView, Mockito.times(1)).drawNumber(0, 4+6, 114+7*2+3);
        Mockito.verify(scoreView, Mockito.times(1)).drawNumber(1, 4+6,  148);
        Mockito.verify(scoreView, Mockito.times(1)).drawNumber(0, 4+6, 157);
    }


}
