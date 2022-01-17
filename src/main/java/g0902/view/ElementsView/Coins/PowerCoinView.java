package g0902.view.ElementsView.Coins;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.Constants;
import g0902.Draws;
import g0902.model.Game.MapElements.Coins.PowerCoin;

public class PowerCoinView extends CoinsView {
    private PowerCoin powerCoin;

    public PowerCoinView(PowerCoin powerCoin, TextGraphics graphics) {
        super(graphics);
        this.powerCoin = powerCoin;
    }


    @Override
    public void draw() {
        graphics.setBackgroundColor(TextColor.Factory.fromString(Constants.WHITE));  // set color to white

        int y = 0;
        for (String s : Draws.POWER_COIN ){
            for (int x = 0; x < s.length(); x++){
                if (s.charAt(x) == '#')
                    graphics.fillRectangle(new TerminalPosition( powerCoin.getPosition().getCol() + x *2 -3, powerCoin.getPosition().getRow() + y),  new TerminalSize(2, 1), ' ');
            }
            y++;
        }
    }
}
