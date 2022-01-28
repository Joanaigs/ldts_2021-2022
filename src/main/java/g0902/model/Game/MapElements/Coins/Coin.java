package g0902.model.Game.MapElements.Coins;

import g0902.model.Game.MapElements.Element;
import g0902.model.Game.MapElements.Wall;
import g0902.model.Position;

public abstract class Coin extends Element {

    public Coin(Position position, int width, int height) {
        super(position, width, height);
    }


    @Override
    @SuppressWarnings("EqualsHashCode")
    public boolean equals(Object obj) {
        if (this.position == obj) return true;
        if (!(obj instanceof Coin)) return false;
        Coin coin = (Coin) obj;
        return coin.getPosition().equals(position);
    }

}
