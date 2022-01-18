package g0902;

public class Configuration {
    private static Configuration config;
    long frightenedTime;
    long chaseTime;
    Music menuMusic, normalMode, frightenedMode, endScreen;

    private Configuration(){
        frightenedTime = 9000;  //ms
        chaseTime = 20000;
        menuMusic = new Music("menuMusic.wav");
        frightenedMode = new Music("frightenedModeMusic.wav");
        normalMode = new Music("normalModeMusic.wav");
        endScreen =  new Music("endScreenSound.wav");
    }

    public void stopAllMusic(){
        menuMusic.stop();
        normalMode.stop();
        frightenedMode.stop();
        endScreen.stop();
    }

    public  void stopGameMusic(){
        menuMusic.stop();
        normalMode.stop();
        frightenedMode.stop();
    }

    public Music getEndScreenMusic() {return endScreen;}

    public Music getMenuMusic() {return menuMusic;}

    public Music getFrightenedModeMusic() {return frightenedMode;}

    public Music getNormalModeMusic() {return normalMode;}

    public static Configuration getInstance() {
        if(config==null)
            config = new Configuration();
        return config ;
    }

    public long getFrightenedTime() {return frightenedTime;}

    public long getChaseTime() {return chaseTime;}

    public void nextLevel(){
        if( frightenedTime >1000)
            frightenedTime -= 2000;
        chaseTime += 2000;
    }

    //only for tests:
    public static void clearConfiguration(){
        config = null;
    }
}
