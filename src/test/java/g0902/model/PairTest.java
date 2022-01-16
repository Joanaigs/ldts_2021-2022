package g0902.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PairTest {
    @Test
    void equalsTest(){
        Pair pair1=new Pair(1, 2);
        Pair pair2=new Pair(1, 2);
        Position position=new Position(1,2);
        Assertions.assertEquals(true, pair1.equals(pair2));
        Assertions.assertEquals(true, pair1.equals(pair1));
        Assertions.assertEquals(true, position.equals(new Position(1, 2)));
        Assertions.assertEquals(false, pair1.equals(position));
        Assertions.assertEquals(994, pair1.hashCode());
    }
}
