package model.Elements;

import model.Position;

public class Pacman extends Element{
    private int highscore;
    private double velocity = 62/3;                 // vai mudando com o jogo


    public Pacman(Position position) {
        super(position);
        highscore = 0;
    }

    public Direction moveUp() {return Direction.Up;}

    public Direction moveDown() {return Direction.Down;}

    public Direction moveLeft() {return Direction.Left;}

    public Direction moveRight() {return Direction.Right;}


    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }

}
