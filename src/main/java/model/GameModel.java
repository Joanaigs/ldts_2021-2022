package model;

import model.Elements.Wall;
import model.Maps.Builders.MapBuilder;
import model.Maps.Builders.MapReader;
import model.Maps.Map;

import java.io.IOException;

public class GameModel implements Model {
    Map map;

    public GameModel() throws IOException {
        MapBuilder mapBuilder = new MapReader();
        map = mapBuilder.createMap("map");
    }

    public Map getMap() {
        return map;
    }
}