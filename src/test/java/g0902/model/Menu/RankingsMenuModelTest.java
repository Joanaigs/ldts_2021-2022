package g0902.model.Menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RankingsMenuModelTest {
    @Test
    public void rankings() throws IOException {
        RankingsMenuModel rankingsMenuModel=new RankingsMenuModel();
        rankingsMenuModel.readFile("RankingsTest");
        rankingsMenuModel.sortD();
        Assertions.assertEquals(2, rankingsMenuModel.getScores().size());
        Assertions.assertEquals(2000,rankingsMenuModel.getScores().get(0).getR());
        Assertions.assertEquals("JGS",rankingsMenuModel.getScores().get(0).getL());
        rankingsMenuModel.addScore("ART", 10);
        Assertions.assertEquals(3,rankingsMenuModel.getScores().size());
    }
}