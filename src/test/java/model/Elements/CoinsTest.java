package model.Elements;

import model.Maps.Builders.MapBuilder;
import model.Maps.Builders.MapReader;
import model.Maps.Map;
import model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CoinsTest extends Assertions {
    @Test
        //Tests if the coins are being correctly read from the map.
    void readCoinsTest() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        Map map = mapbuilder.createMap("mapTest2"); // here we are using a 6x6 map to test if the functions are working.


        //To see if it's reading the right number of coins
        assertEquals(4, map.getCoins().size());

        // List of each power coin position on the map "mapTest"
        ArrayList<Coins> coinsList = new ArrayList<Coins>(
                Arrays.asList(new PowerCoin(new Position(2 * 8 + 1, 12 * 12 - 1)),
                        new PowerCoin(new Position(2 * 8 + 1, 30 * 12 - 1)),
                        new SmallCoin(new Position(2 * 8 + 1, 14 * 12 - 1)),
                        new SmallCoin(new Position(2 * 8 + 1, 16 * 12 - 1))));

        //To see if it's reading the correct power coins
        assertEquals(true, coinsList.containsAll(map.getPowerCoins()));
        assertEquals(true, coinsList.containsAll(map.getSmallCoins()));
        assertEquals(true, coinsList.containsAll(map.getCoins()));
        assertEquals(true, map.getPowerCoins().containsAll(coinsList));
    }
}
