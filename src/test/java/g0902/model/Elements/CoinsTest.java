package g0902.model.Elements;

import g0902.model.Elements.Coins.Coin;
import g0902.model.Elements.Coins.PowerCoin;
import g0902.model.Elements.Coins.SmallCoin;
import g0902.model.Maps.Builders.MapBuilder;
import g0902.model.Maps.Builders.MapReader;
import g0902.model.Maps.Map;
import g0902.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoinsTest extends Assertions {
    @Test
        //Tests if the coins are being correctly read from the map.
    void readCoinsTest() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        Map map = mapbuilder.createMap("mapTest2"); // here we are using a 6x6 map to test if the functions are working.


        //To see if it's reading the right number of coins
        assertEquals(4, map.getCoins().size());

        // List of each power coin position on the map "mapTest"
        List<Coin> coinsList = new ArrayList<Coin>();
        coinsList.add(new PowerCoin(new Position(2 * 8 + 1, 12 * 12 - 1)));
        coinsList.add(new PowerCoin(new Position(2 * 8 + 1, 30 * 12 - 1)));
        coinsList.add(new SmallCoin(new Position(2 * 8 + 1, 14 * 12 - 1)));
        coinsList.add(new SmallCoin(new Position(2 * 8 + 1, 16 * 12 - 1)));

        for (Coin p: map.getCoins()) {
            System.out.println(p.getPosition().getRow());
            System.out.println(p.getPosition().getCol());
        }

        //To see if it's reading the correct coins
        assertTrue(coinsList.containsAll(map.getPowerCoins()));
        assertTrue(coinsList.containsAll(map.getSmallCoins().values()));
        assertEquals(true, coinsList.containsAll(map.getCoins()));
        assertEquals(true, map.getCoins().containsAll(coinsList));
    }
}
