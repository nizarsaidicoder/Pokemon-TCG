import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Pookemon {
  public static void main(String args[])
  {
    String filePath = "src/Utils/music.wav"; // The path to the audio file
    // Create a new thread to play the music in the background
    Thread musicThread = new Thread(() -> {
      try {
        // Open the audio file
        File audioFile = new File(filePath);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);

        // Get the clip for playing the audio
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        // Start playing the audio
        clip.start();

        // Loop the audio playback if needed
        clip.loop(Clip.LOOP_CONTINUOUSLY);

        // Wait for the clip to finish playing
        Thread.sleep(Long.MAX_VALUE);
      } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
        e.printStackTrace();
      }
    });

    // Start the music thread
    musicThread.start();
    Game game = new Game();
    game.start();

  }
}
