package Pokemon;

import javax.sound.sampled.*;
import java.io.File;

public class Pokemon
{
  /**
   * Attributs
   */
  private String m_name;
  private int m_hp;
  private int m_hpMax;
  private int m_attack;
  private Affinity m_affinity;
  private boolean m_isPlayable;

  //constructeur
  public Pokemon(String name, int hp, int attack, Affinity affinity)
  {
    m_name = name;
    m_hp = hp;
    m_hpMax = hp;
    m_attack = attack;
    m_affinity = affinity;
  }

  /**
   * Attaque un autre pokémon avec gestion de l'affinité
   * @param pokemon pokémon qui reçoit les dégâts
   */
  public void attack(Pokemon pokemon)
  {
    String filePath = "src/Utils/attack.wav"; // The path to the audio file
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
        // Wait for the clip to finish playing
        Thread.sleep(Long.MAX_VALUE);
      } 
      catch ( Exception e) //UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException |
      {        
        //e.printStackTrace();
      }
    });

    // Start the music thread
    musicThread.start();
    int damages = m_attack;

    //si l'élément du pokémon a un avantage sur celui du pokémon qui est attaqué alors les dégâts sont augmentés de 10
    if(m_affinity.getStrength() == pokemon.m_affinity.getElement())
    {
      damages += 10;
    }

    //si l'élément du pokémon a une faiblesse sur celui du pokémon qui est attaqué alors les dégâts sont diminués de 10
    if(m_affinity.getWeakness() == pokemon.m_affinity.getElement())
    {
      damages -= 10;
    }


    if(damages > pokemon.m_hp)
    {
      pokemon.m_hp = 0;
    }
    else
    {
      pokemon.m_hp -= damages;
    }
  }
  public boolean isStrongTo(Affinity affinity)
  {
    return m_affinity.getElement() == affinity.getWeakness();
  }
  /**
   * Méthode pour vérifier si le pokemon est vivant
   * @return true si le pokemon est vivant, false sinon
   */
  public boolean isAlive()
  {
    return m_hp > 0;
  }
  /*
    * Méthode pour vérifier si le pokemon est jouable
   */
  public boolean isPlayable()
  {
    return m_isPlayable;
  }

  //accesseurs
  public String getName()
  {
    return m_name;
  }

  /**
   * Retourne la vie actuelle du pokémon
   * @return vie pokémon
   */
  public int getHP()
  {
    return m_hp;
  }

  /**
   * Retourne la vie maximale du pokémon
   * @return vie maximale pokémon
   */
  public int getHPMax()
  {
    return m_hpMax;
  }

  /**
   * Retourne l'attaque du pokémon
   * @return attaque pokémon
   */
  public int getAttack()
  {
    return m_attack;
  }
  public Affinity getAffinity()
  {
    return m_affinity;
  }
  public void setPlayable(boolean isPlayable)
  {
      m_isPlayable = isPlayable;
  }

  @Override
  /**
   * Affichage pokémon
   * @return "<nom>, <affinité>, HP : <hp>, Attack : <attaque>"
   */
  public String toString()
  {
    return String.format("%s, %s, HP : %d, Attack : %d", m_name, m_affinity.getElement(), m_hp, m_attack);
  }

}
