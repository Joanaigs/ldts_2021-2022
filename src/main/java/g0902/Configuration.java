package g0902;

public class Configuration {
    private static Configuration config;
    long frightenedTime;
    long chaseTime;

    private Configuration(){
        frightenedTime = 9000;  //ms
        chaseTime = 20000;
    }

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
