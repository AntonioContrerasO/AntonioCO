import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class MusicStuff {

    Clip clip;
    String string;
    int x;

    public MusicStuff(String string) {
     this.string = string;
    }

    public void playMusic()
    {

        String musicLocation = "src/Imagenes/"+string+".wav";

        try {
            File musicPath = new File(musicLocation);

            if (musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else
            {
                System.out.println("No jalo perro");
            }

        }catch (Exception e)
        {

        }
    }

    public void StopPlaying()
    {
        this.x = clip.getFramePosition();
        clip.stop();

    }
    public void pause()
    {
        clip.setMicrosecondPosition(x);
        clip.start();
    }
}
