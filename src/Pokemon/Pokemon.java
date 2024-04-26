package Pokemon;

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
  public Pokemon(String name, int hp, int hpMax, int attack, Affinity affinity)
  {
    m_name = name;
    m_hp = hp;
    m_hpMax = hpMax;
    m_attack = attack;
    m_affinity = affinity;
  }

  /**
   * Attaque un autre pokémon
   * @param pokemon pokémon qui reçoit les dégâts
   */
  public void attack(Pokemon pokemon)
  {
    if(m_attack > pokemon.m_hp)
    {
      pokemon.m_hp = 0;
    }
    else
    {
      pokemon.m_hp -= m_attack;
    }
  }
  /*
   * Méthode pour vérifier si le pokemon est vivant
   */
  public boolean isAlive()
  {
    // Le pokemon est vivant si et seulement si m_hp > 0
    return false;
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
    return String.format("%s, %s, HP : %d, Attack : %d", m_name, m_affinity, m_hp, m_attack);
  }

}
