package view.ElementsView.Coins;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.Elements.Coins.PowerCoin;
import view.ElementsView.Coins.CoinsView;

public class PowerCoinView extends CoinsView {
    private PowerCoin powerCoin;

    public PowerCoinView(PowerCoin powerCoin, TextGraphics graphics) {
        super(graphics);
        this.powerCoin = powerCoin;
    }

    private static final String[] powCoin = {

            "   ###### ",
            "  ##    ##",
            " ##      ##",
            " ##      ##",
            " ##      ##",
            " ##      ##",
            "  ##    ##",
            "   ######",
    };


    @Override
    public void draw() {
        // set color to white
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        int y = 0;

        for (String s : powCoin ){
            for (int x = 0; x < s.length(); x++){
                if (s.charAt(x) == '#')
                    graphics.fillRectangle(new TerminalPosition(
                                    powerCoin.getPosition().getCol() + x *2 -3, powerCoin.getPosition().getRow() + y),
                            new TerminalSize(2, 1), ' ');
            }
            y++;
        }
    }
}
