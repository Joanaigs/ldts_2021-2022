package g0902;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.Clip;

import static org.mockito.Mockito.*;

public class MusicTest{
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
}
