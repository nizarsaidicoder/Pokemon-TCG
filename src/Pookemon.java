import Game.Game;

import java.io.File;
//import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
//import javax.sound.sampled.LineUnavailableException;
//import javax.sound.sampled.UnsupportedAudioFileException;

public class Pookemon {
  public static void main(String args[])
  {
    Thread musicThread = new Thread(() -> {
      try {
        File audioFile = new File("src/UI/music.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);

        Thread.sleep(Long.MAX_VALUE);
      } 
      catch (Exception e) { 
        e.printStackTrace();
      }
    });
    musicThread.start();
    Game game = new Game();
    game.start();
    musicThread.interrupt();
  }

}
