package g0902.model.Game.MapElements;

import g0902.model.Game.MapElements.Coins.PowerCoin;
import g0902.model.Game.Map.Builders.MapBuilder;
import g0902.model.Game.Map.Builders.MapReader;
import g0902.model.Game.Map.Map;
import g0902.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class PowerCoinTest extends Assertions{

    @Test
        //Tests if the power coins are being correctly read from the map.
    void readPowerCoinsTest() throws IOException {
        MapBuilder mapbuilder = new MapReader();
        Map map = mapbuilder.createMap("mapTest2"); // here we are using a 6x6 map to test if the functions are working.


        //To see if it's reading the right number of power coins
        assertEquals(2, map.getPowerCoins().size());

        // List of each power coin position on the map "mapTest"
        List<PowerCoin> powerCoinsList = new ArrayList<PowerCoin>();
        powerCoinsList.add(new PowerCoin(new Position(2 * 8 + 1, 12 * 12 - 1)));
        powerCoinsList.add(new PowerCoin(new Position(2 * 8 + 1, 30 * 12 - 1)));

        //To see if it's reading the correct power coins
        assertTrue(powerCoinsList.containsAll(map.getPowerCoins()));
        assertEquals(true, map.getPowerCoins().containsAll(powerCoinsList));
    }

}