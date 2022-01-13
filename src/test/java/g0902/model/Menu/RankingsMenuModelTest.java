package g0902.model.Menu;

import g0902.model.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class RankingsMenuModelTest {
    private RankingsMenuModel rankingsMenuModel;

    @BeforeEach
    public void setUp(){
        rankingsMenuModel=new RankingsMenuModel();
        rankingsMenuModel.readFile("RankingsTest");
        rankingsMenuModel.sortD();
    }

    @Test
    public void rankings() throws IOException {
        Assertions.assertTrue(rankingsMenuModel.isRunning());
        rankingsMenuModel.setRunning(false);
        Assertions.assertFalse(rankingsMenuModel.isRunning());

        RankingsMenuModel rankingsMenuModel1 = new RankingsMenuModel();
        Assertions.assertEquals(false, rankingsMenuModel1.getScores().get(0).getR()<rankingsMenuModel1.getScores().get(1).getR());

        rankingsMenuModel.addScore("ART", 10);
        Assertions.assertEquals(3,rankingsMenuModel.getScores().size());
    }

    @Test
    public void sortDTest() throws IOException {
        Assertions.assertEquals(2, rankingsMenuModel.getScores().size());
        Assertions.assertEquals(2000,rankingsMenuModel.getScores().get(0).getR());
        Assertions.assertEquals("Player",rankingsMenuModel.getScores().get(0).getL());

        rankingsMenuModel.setScores(new ArrayList<>());
        rankingsMenuModel.addScore("Player1", 30);
        rankingsMenuModel.addScore("Player2", 100);
        rankingsMenuModel.sortD();
        List<Pair<String, Integer>> scores = new ArrayList<>();
        scores.add((new Pair<>("Player2", 100)));
        scores.add((new Pair<>("Player1", 30)));

        Assertions.assertTrue(rankingsMenuModel.getScores().get(0).equals(scores.get(0)));
        Assertions.assertTrue(rankingsMenuModel.getScores().get(1).equals(scores.get(1)));
    }

    @Test
    public void updateTest() throws IOException {
        rankingsMenuModel.addScore("ART", 10);
        rankingsMenuModel.updateFile();
        rankingsMenuModel.setScores(new ArrayList<>());
        rankingsMenuModel.readFile("RankingsTest");
        Assertions.assertEquals(3,rankingsMenuModel.getScores().size());
        List<Pair<String, Integer>> scores = rankingsMenuModel.getScores();
        scores.remove(2);
        rankingsMenuModel.setScores(scores);
        rankingsMenuModel.updateFile();
    }
/*
    @Test
    public void readTest(){
        RankingsMenuModel rankings = mock(RankingsMenuModel.class);
        doThrow(new FileNotFoundException()).when(rankings).readFile("NaoExiste");
        rankings.readFile("NaoExiste");
    }
*/
}
