package model.Menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RankingsMenuModelTest {
    @Test
    public void rankings() throws IOException {
        RankingsMenuModel rankingsMenuModel=new RankingsMenuModel();
        Assertions.assertEquals(2, rankingsMenuModel.getScores().size());
        Assertions.assertEquals(2000,rankingsMenuModel.getScores().get(0).getR());
        rankingsMenuModel.addScore("ART", 10);
        Assertions.assertEquals(3,rankingsMenuModel.getScores().size());
    }
}
