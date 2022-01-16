package g0902.view.ElementsView;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.Constants;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;


public class ScoreViewTest extends Assertions {
    TextGraphics textGraphics;
    Pacman pacman;
    ScoreView scoreView;

    @BeforeEach
    void create(){
        textGraphics = Mockito.mock(TextGraphics.class);
        pacman = Mockito.mock(Pacman.class);
        scoreView = Mockito.spy(new ScoreView(pacman, textGraphics));
    }

    @Test
    void draw() throws IOException {
        Mockito.when(pacman.getScore()).thenReturn(10);
        //when
        scoreView.draw();
        //then
        Mockito.verify(scoreView, Mockito.times(1)).drawScore();
        Mockito.verify(scoreView, Mockito.times(1)).drawNumber(0, 39*8+6, 97);
        Mockito.verify(scoreView, Mockito.times(1)).drawNumber(0, 39*8+6, 97+7*2+3);
        Mockito.verify(scoreView, Mockito.times(1)).drawNumber(0, 39*8+6, 114+7*2+3);
        Mockito.verify(scoreView, Mockito.times(1)).drawNumber(1, 39*8+6,  148);
        Mockito.verify(scoreView, Mockito.times(1)).drawNumber(0, 39*8+6, 157);
    }


    private void compareArrays(String[] arr2, String[] arr1){
        assertEquals(arr1.length, arr2.length);
        for (int i = 0; i < arr1.length; i++)
            assertEquals(arr1[i], arr2[i]);
    }

    @Test
    void loadNumbers(){
        // given
        String [] n0 = new String[]{
                " ######",
                "##  ####",
                "## ## ##",
                "####  ##",
                " ######"};
        String [] n1 = new String[]{
                " ##",
                "###",
                " ##",
                " ##",
                " ##",};
        String [] n2 = new String[]{
                "######",
                "     ##",
                " #####",
                "##",
                "#######",};
        String [] n3 = new String[]{
                "######",
                "     ##",
                " #####",
                "     ##",
                "######"};
        String [] n4 = new String[]{
                "##   ##",
                "##   ##",
                "#######",
                "     ##",
                "     ##"};
        String [] n5 = new String[]{
                "#######",
                "##",
                "#######",
                "     ##",
                "#######"};
        String [] n6 = new String[]{
                " ######",
                "##",
                "#######",
                "##    ##",
                " ######"};
        String [] n7 = new String[]{
                " #######",
                "      ##",
                "     ##",
                "    ##",
                "    ##"};
        String [] n8 = new String[]{
                " #####",
                "##   ##",
                " #####",
                "##   ##",
                " #####"};
        String [] n9 = new String[]{
                " #####",
                "##   ##",
                " ######",
                "     ##",
                " #####"};
        // when
        List<String[]> numbers = scoreView.getNumbers();

        // then

        assertEquals(10 , numbers.size());
        compareArrays(n0, numbers.get(0));
        compareArrays(n1, numbers.get(1));
        compareArrays(n2, numbers.get(2));
        compareArrays(n3, numbers.get(3));
        compareArrays(n4, numbers.get(4));
        compareArrays(n5, numbers.get(5));
        compareArrays(n6, numbers.get(6));
        compareArrays(n7, numbers.get(7));
        compareArrays(n8, numbers.get(8));
        compareArrays(n9, numbers.get(9));
    }


    @Test
    void drawNumber(){
        List<String[]> tnumbers = List.of(
                new String[]{"##########"},
                new String[]{"#"},
                new String[]{"##"},
                new String[]{"###"},
                new String[]{"####"},
                new String[]{"#####"}
        );

        Mockito.doReturn(tnumbers).when(scoreView).getNumbers();
        for( int i=0; i <= 5; i++){
            scoreView.drawNumber(i, 1,i*20);
            for( int col =0; col < tnumbers.get(i)[0].length(); col++) {
               if(tnumbers.get(i)[0].charAt(col) == '#')
                   Mockito.verify(scoreView, Mockito.times(1)).fillTheRectangles(i*20 + col*2, 1);
            }
        }
    }

    @Test
    void drawScore(){
        scoreView.drawScore();
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        int y = 0;
        for (String s : Constants.SCORE){
            for (int x = 0; x < s.length(); x++){
                if (s.charAt(x) == '#')
                    Mockito.verify(scoreView, Mockito.times(1)).fillTheRectangles(4+x*2, 39*8+y*2+6);
            }
            y++;
        }
    }

}
