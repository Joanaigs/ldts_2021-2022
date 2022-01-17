package g0902.model.Menu;

import g0902.model.Pair;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RankingsMenuModelTest {
    private RankingsMenuModel rankingsMenuModel;

    @BeforeEach
    public void setUp() throws IOException {
        rankingsMenuModel=new RankingsMenuModel();
        rankingsMenuModel.readFile("RankingsTest");
        rankingsMenuModel.addScore("JIG", 1000);
        rankingsMenuModel.addScore("JIG", 2000);
        rankingsMenuModel.updateFile();
    }

    public void destroy() throws IOException {
        List<Pair<String, Integer>> scores = rankingsMenuModel.getScores();
        while (!scores.isEmpty()) {
            scores.remove(0);
        }
        rankingsMenuModel.setScores(scores);
        rankingsMenuModel.updateFile();
    }

    @Test
    public void rankings() throws IOException {
        rankingsMenuModel.readFile("RankingsTest");
        rankingsMenuModel.sortD();
        Assertions.assertTrue(rankingsMenuModel.isRunning());
        rankingsMenuModel.setRunning(false);
        Assertions.assertFalse(rankingsMenuModel.isRunning());

        RankingsMenuModel rankingsMenuModel1 = new RankingsMenuModel();
        Assertions.assertEquals(false, rankingsMenuModel1.getScores().get(0).getR()<rankingsMenuModel1.getScores().get(1).getR());

        rankingsMenuModel.addScore("ART", 10);
        Assertions.assertEquals(3,rankingsMenuModel.getScores().size());

        destroy();
    }

    @Test
    public void sortDTest() throws IOException {
        rankingsMenuModel.readFile("RankingsTest");
        rankingsMenuModel.sortD();
        Assertions.assertEquals(2, rankingsMenuModel.getScores().size());
        Assertions.assertEquals(2000,rankingsMenuModel.getScores().get(0).getR());
        Assertions.assertEquals("JIG",rankingsMenuModel.getScores().get(0).getL());

        rankingsMenuModel.setScores(new ArrayList<>());
        rankingsMenuModel.addScore("Pla", 30);
        rankingsMenuModel.addScore("Ply", 100);
        rankingsMenuModel.sortD();
        List<Pair<String, Integer>> scores = new ArrayList<>();
        scores.add((new Pair<>("Ply", 100)));
        scores.add((new Pair<>("Pla", 30)));

        Assertions.assertTrue(rankingsMenuModel.getScores().get(0).equals(scores.get(0)));
        Assertions.assertTrue(rankingsMenuModel.getScores().get(1).equals(scores.get(1)));

        destroy();
    }

    @Test
    public void updateTest() throws IOException {
        rankingsMenuModel.setScores(new ArrayList<>());
        rankingsMenuModel.readFile("RankingsTest");
        rankingsMenuModel.addScore("ART", 10);
        rankingsMenuModel.updateFile();
        Assertions.assertEquals(3,rankingsMenuModel.getScores().size());
        List<Pair<String, Integer>> scores = rankingsMenuModel.getScores();
        scores.remove(2);
        rankingsMenuModel.setScores(scores);
        rankingsMenuModel.updateFile();

        destroy();
    }
    @Test
    public void readTest() throws IOException {
        destroy();
        Assertions.assertThrows(FileNotFoundException.class, () -> rankingsMenuModel.readFile("aaaa"));
    }

}
