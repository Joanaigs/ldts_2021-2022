package g0902;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import static org.mockito.Mockito.*;

public class MusicTest extends Assertions{
    Music music;
    @BeforeEach
    void setUp(){
        music=new Music("menuMusic.wav");
    }

    @Test
    public void loadSoundTest(){
        Assertions.assertEquals(null, music.loadSound("a.wav"));
    }

    @Test
    public void MusicTest(){
        Clip sound=mock(Clip.class);
        music.setSound(sound);
        Assertions.assertEquals(false, music.isPlaying());
        when(sound.isRunning()).thenReturn(true);
        music.start();
        Assertions.assertEquals(true, music.isPlaying());
        Mockito.verify(sound, times(1)).setMicrosecondPosition(0);
        Mockito.verify(sound, times(1)).start();
        Mockito.verify(sound, times(1)).loop(Clip.LOOP_CONTINUOUSLY);
    }

    @Test
    void createAndLoadSound() {
        String path = "endScreenSound.wav";
        music = new Music(path);
        FloatControl floatControl = (FloatControl) music.getSound().getControl(FloatControl.Type.MASTER_GAIN);
        assertNotNull(music);
        assertEquals(-25.0f, floatControl.getValue());
    }
}
