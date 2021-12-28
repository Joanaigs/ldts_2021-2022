package view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.Elements.SmallCoin;

public class SmallCoinView extends CoinsView{

    private SmallCoin smallCoin;

    private static final String[] sCoin = {

            " ### ",
            "#####",
            "#####",
            " ### ",
    };


    public SmallCoinView(SmallCoin smallCoin, TextGraphics graphics) {
        super(graphics);
        this.smallCoin = smallCoin;
    }


    @Override
    public void draw() {
        // set color to white
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        int y = 0;

        for (String s : sCoin ){
            for (int x = 0; x < s.length(); x++){
                if (s.charAt(x) == '#')
                    graphics.fillRectangle(new TerminalPosition(
                                    smallCoin.getPosition().getCol() + x *2 + 2 , smallCoin.getPosition().getRow() + y + 2),
                            new TerminalSize(2, 1), ' ');
            }
            y++;
        }
    }
}
