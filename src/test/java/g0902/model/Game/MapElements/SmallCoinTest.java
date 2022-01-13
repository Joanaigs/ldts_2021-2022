package g0902.model.Game.MapElements;

import g0902.model.Game.MapElements.Coins.SmallCoin;
import g0902.model.Game.Map.Builders.MapBuilder;
import g0902.model.Game.Map.Builders.MapReader;
import g0902.model.Game.Map.Map;
import g0902.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;


class SmallCoinTest extends Assertions {
    @Test
        //Tests if the small coins are being correctly read from the map.
    void readSmallCoinsTest() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        Map map = mapbuilder.createMap("mapTest2"); // here we are using a 6x6 map to test if the functions are working.


        //To see if it's reading the right number of small coins
        assertEquals(2, map.getSmallCoins().size());

        // List of each small coin position on the map "mapTest"
        ArrayList<SmallCoin> smallCoinsList = new ArrayList<SmallCoin>();
        smallCoinsList.add(new SmallCoin(new Position(2 * 8 + 1, 14 * 12 - 1)));
        smallCoinsList.add(new SmallCoin(new Position(2 * 8 + 1, 16 * 12 - 1)));

        //To see if it's reading the correct small coins
        assertEquals(true, smallCoinsList.containsAll(map.getSmallCoins().values()));
        assertEquals(true, map.getSmallCoins().values().containsAll(smallCoinsList));
    }

}