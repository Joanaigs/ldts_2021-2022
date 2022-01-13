package g0902.model.Game.MapElements.Coins;

import g0902.model.Game.MapElements.Element;
import g0902.model.Position;

public abstract class Coin extends Element {

    public Coin(Position position, int width, int height) {
        super(position, width, height);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coin coin = (Coin) obj;
        return coin.getPosition().equals(position);
    }

}
