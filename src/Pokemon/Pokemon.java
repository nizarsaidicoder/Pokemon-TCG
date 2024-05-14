package Pokemon;

import Utils.UIFunctions;

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
  public void display()
  {
    String out = UIFunctions.getCorrespondingColor(m_affinity.getElement()) + UIFunctions.padRight(m_name,20) + UIFunctions.getColorCode("reset") +  " | " + UIFunctions.padRight(Integer.toString(m_hp) ,20) + " | " + UIFunctions.getCorrespondingColor(m_affinity.getElement()) + UIFunctions.padRight( m_affinity.getElement().toString(), 20 )+ UIFunctions.getColorCode("reset") + " | " + m_attack ;
    System.out.println(out);
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
