package g0902;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class Music {
    private Clip sound;

    public boolean isPlaying(){return sound.isRunning();}

    public Music(String sound) {
        this.sound = loadSound(sound);
    }

    public Clip loadSound(String sound) throws NullPointerException{
        try {
            File musicFile = new File(getClass().getClassLoader().getResource(sound).toURI());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void start() {
        sound.setMicrosecondPosition(0);
        sound.start();
        sound.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {sound.stop();}

    public void setSound(Clip sound) {
        this.sound = sound;
    }

}
