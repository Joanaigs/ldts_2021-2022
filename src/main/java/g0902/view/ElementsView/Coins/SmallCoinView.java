package g0902.view.ElementsView.Coins;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.view.ElementsView.Constants;
import g0902.model.Game.MapElements.Coins.SmallCoin;

public class SmallCoinView extends CoinsView {

    private SmallCoin smallCoin;

    public SmallCoinView(SmallCoin smallCoin, TextGraphics graphics) {
        super(graphics);
        this.smallCoin = smallCoin;
    }


    @Override
    public void draw() {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFC6B6")); // set color to salmon
        int y = 0;

        for (String s : Constants.SMALL_COIN){
            for (int x = 0; x < s.length(); x++){
                if (s.charAt(x) == '#')
                    graphics.fillRectangle(new TerminalPosition(smallCoin.getPosition().getCol() + x *2 + 1 , smallCoin.getPosition().getRow() + y -2), new TerminalSize(2, 1), ' ');
            }
            y++;
        }
    }
}
