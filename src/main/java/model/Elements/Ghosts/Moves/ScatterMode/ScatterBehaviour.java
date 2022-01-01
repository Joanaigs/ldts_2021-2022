package model.Elements.Ghosts.Moves.ScatterMode;

import model.Elements.Direction;

public interface ScatterBehaviour {

    void findToGoPosition();

    Direction Scatter(long deltatime);
}

// cada um deles fica a rondar mais posiçoes