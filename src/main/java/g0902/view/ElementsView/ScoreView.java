package g0902.view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import g0902.Constants;
import g0902.Draws;
import g0902.model.Game.MapElements.MovingElements.Pacman;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreView extends View {
    static final int height= 2, width = 2;
    List<String[]>  numbers;
    Pacman pacman;

    public ScoreView(Pacman pacman, TextGraphics graphics) {
        super(graphics);
        this.pacman = pacman;
        numbers = new ArrayList<>();
        try {
            loadNumbers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw() throws IOException {
        drawScore();

        int pacmanScore = pacman.getScore();
        String score = String.format("%05d", pacmanScore);
        int col = 90;
        for(char digit : score.toCharArray()) {
            int n = Integer.parseInt(digit+"");
            drawNumber(n, 39*8+6, col+7);
            col += numbers.get(n)[0].length()*width+3;
        }
    }


    public void loadNumbers() throws IOException {
        String rootPath = new File(System.getProperty("user.dir")).getPath();
        String mapLocation = rootPath + "/src/main/resources/numbers.font";
        FileReader fr = new FileReader(mapLocation);
        BufferedReader br = new BufferedReader(fr);
        int height = Integer.parseInt(br.readLine());

        for (int n = 0; n <= 9; n++) {
            String[] number = new String[height];
            for (int i = 0; i < height; i++) {
                number[i] = br.readLine();
            }
            numbers.add(number);
        }
    }

    public void drawNumber(int number, int terminalRow, int terminalCol){
        String[] numberDraw = getNumbers().get(number);
        for(int row = 0; row < numberDraw.length; row++){
            for(int col =0; col < numberDraw[row].length(); col++){
                if( numberDraw[row].charAt(col) ==  '#' ){
                    fillTheRectangles(terminalCol + col*width, terminalRow+row*height);
                }
            }
        }
    }

    public void drawScore(){
        graphics.setBackgroundColor(TextColor.Factory.fromString(Constants.WHITE));  // set color to white

        int y = 0;
        for (String s : Draws.SCORE){
            for (int x = 0; x < s.length(); x++){
                if (s.charAt(x) == '#')
                    fillTheRectangles(4+x*width, 39*8+y*height+6);
            }
            y++;
        }
    }

    public void fillTheRectangles(int x, int y){graphics.fillRectangle(new TerminalPosition(x, y), new TerminalSize(width, height), ' ');}

    public List<String[]> getNumbers() {return numbers;}
}
