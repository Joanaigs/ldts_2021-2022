package model.Maps.Builders;

import model.Maps.Map;

import java.io.IOException;

public interface MapBuilder {
    Map createMap(String mapName) throws IOException;
}
