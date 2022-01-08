package g0902.model.Maps.Builders;

import g0902.model.Maps.Map;

import java.io.IOException;

public interface MapBuilder {
    Map createMap(String mapName) throws IOException;
}
