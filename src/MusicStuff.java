import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class MusicStuff {

    Clip clip;
    String string;

    public MusicStuff(String string) {
     this.string = string;
    }

    public void playMusic(int vueltas)
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
                clip.loop(vueltas);
            }
            else
            {
                System.out.println("No jalo perro");
            }

        }catch (Exception e)
        {

        }
    }

    public void play()
    {
        clip.start();
        clip.loop(1);
    }

    public void StopPlaying()
    {
        clip.stop();
    }
}
