package g0902.model.Game.Map.Builders;

import g0902.model.Game.MapElements.*;
import g0902.model.Game.MapElements.Coins.PowerCoin;
import g0902.model.Game.MapElements.Coins.SmallCoin;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Cyan;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Orange;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Pink;
import g0902.model.Game.MapElements.MovingElements.Ghosts.Types.Red;
import g0902.model.Game.Map.Map;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import g0902.model.Position;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MapReader implements MapBuilder {
    private int height;

    private enum MapElement{
        Wall('#'), Red('R'), Pink('P'), Orange('O'), Cyan('C'), Pacman('c'), SmallCoin('.'), PowerCoin('o'), INVALID('\0');

        final char symbol;
        MapElement(char symbol){this.symbol = symbol;}
        public char getSymbol() {return symbol;}

        public static MapElement fromChar(char symbol) {
            for(MapElement mapElement : MapElement.values())
                if (mapElement.getSymbol() == symbol)
                    return mapElement;
            return INVALID;
        }
    }

    @Override
    public Map createMap(String mapName) throws IOException {
        Map m = new Map();
        String rootPath = new File(System.getProperty("user.dir")).getPath();
        String mapLocation = rootPath + "/src/main/resources/" + mapName;

        BufferedReader br = Files.newBufferedReader(Paths.get(mapLocation), Charset.defaultCharset());

        int width = Integer.parseInt(br.readLine());
        height = Integer.parseInt(br.readLine());
        m.setSize(width *12, height*8);
        readElements(m, br);
        return m;
    }

    @SuppressWarnings("MissingCasesInEnumSwitch")
    private void readElements(Map map, BufferedReader br) throws IOException {
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                switch(MapElement.fromChar(line.charAt(j))){
                    case Red -> map.setRed(new Red(new Position(i * 8+1, j * 12)));
                    case Pink -> map.setPink(new Pink(new Position(i * 8+1, j * 12)));
                    case Orange -> map.setOrange(new Orange(new Position(i * 8+1, j * 12)));
                    case Cyan -> map.setCyan(new Cyan(new Position(i * 8+1, j * 12)));
                    case Pacman -> map.setPacman(new Pacman(new Position(i * 8, j * 12)));
                    case Wall -> map.addWall(new Wall(new Position(i * 8, j * 12), 13, 9));
                    case SmallCoin -> map.addSmallCoin(new Position(i,j), new SmallCoin(new Position(i * 8 + 1, j * 12 - 1)));
                    case PowerCoin -> map.addPowerCoin(new PowerCoin(new Position(i * 8 + 1, j * 12 - 1)));
                }
            }
        }
    }


}

