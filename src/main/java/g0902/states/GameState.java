package g0902.states;


import g0902.Configuration;
import g0902.Music;
import g0902.control.Observer;
import g0902.control.PacmanController;
import g0902.gui.LanternaGUI;
import g0902.model.Game.GameModel;
import g0902.model.Game.MapElements.MovingElements.Pacman;
import g0902.model.Menu.EndScreenModel;
import g0902.model.Model;
import g0902.view.ElementsView.GameView;
import g0902.view.Viewer;

import java.io.IOException;

public class GameState extends State{
    private GameView gameView;
    private GameModel gameModel;
    private PacmanController pacmanController;
    private long totalTime, pastTime;
    public static final long TIME_FIXED = 20;
    private int levels=50;
    LanternaGUI gui;
    Music music;

    public void initializing() throws IOException {
        gameModel = new GameModel("map");
        pacmanController = new PacmanController(gameModel.getMap().getPacman(), gameModel);
        totalTime = 0;
        pastTime = System.currentTimeMillis();
        gui=new LanternaGUI();
        music = Configuration.getInstance().getMenuMusic();
    }

    public GameState() throws IOException {
        super();
        initializing();
    }

    //for test use only
    public GameState(GameView view, GameModel model, PacmanController controller, Music music, LanternaGUI gui){
        super();
        gameModel=model;
        totalTime = 0;
        pastTime = System.currentTimeMillis();
        pacmanController=controller;
        gameView=view;
        this.music=music;
        this.gui=gui;
    }

    @Override
    public void initScreen(){
        gui.createScreenGame();
        gameView = new GameView(gameModel, gui.getScreen());
    }

    @Override
    public Viewer getViewer() {return gameView;}

    @Override
    public Observer getObserver(){
        return pacmanController;
    }

    @Override
    public Model getModel() {
        return gameModel;
    }

    @Override
    public boolean isRunning() {
        return gameModel.isRunning();
    }

    @Override
    public void step() throws IOException {
        if(music.isPlaying()){
            music.stop();
        }

        totalTime += getTimePassed();
        while(totalTime >= TIME_FIXED) {
            gameModel.update(TIME_FIXED);
            totalTime-=TIME_FIXED;
        }
        gameView.draw();
    }

    @Override
    public State nextState() throws IOException {
        if(Configuration.getInstance().getFrightenedModeMusic().isPlaying())
            Configuration.getInstance().getFrightenedModeMusic().stop();
        boolean lost=gameModel.hasLost();
        int score = gameModel.getMap().getPacman().getScore();
        int lives= gameModel.getMap().getPacman().getLives();
        State state;
        if(!lost && levels!=0) {
            nextLevel(score,lives);
            levels--;
            return this;
        }
        state = new EndScreenState();
        ((EndScreenModel) state.getModel()).setScore(score);
        ((EndScreenModel) state.getModel()).setLost(lost);
        return state;
    }

    private void nextLevel(int score, int lives) throws IOException {
        initializing();
        Configuration.getInstance().nextLevel();
        Pacman pacman=gameModel.getPacman();
        pacman.setScore(score);
        pacman.setLives(lives);
        gameModel.setPacman(pacman);
    }

    public int getLevels(){ return levels;}

    public void setMusic(Music music) {
        this.music = music;
    }

    public long getTimePassed() {
        long now = System.currentTimeMillis();
        long timePassed = now-pastTime;
        pastTime = now;
        return timePassed;
    }

}
