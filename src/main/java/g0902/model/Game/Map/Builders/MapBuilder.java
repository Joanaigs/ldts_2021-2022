package g0902.model.Game.Map.Builders;

import g0902.model.Game.Map.Map;

import java.io.IOException;

public interface MapBuilder {
    Map createMap(String mapName) throws IOException;
}
