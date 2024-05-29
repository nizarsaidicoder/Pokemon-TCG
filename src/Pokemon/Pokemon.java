package Pokemon;
import Pokemon.Affinity.*;

public class Pokemon
{
  /**
   * Attributs
   */
  private String m_name;
  private int m_hp;
  private int m_hpMax;
  private int m_attack;
  private int m_defense = 0;
  private Affinity m_affinity;
  private int m_skillPoints;

  private boolean m_isPoisoned = false;

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
    if(m_affinity.getStrength() == pokemon.m_affinity.getElement() || m_affinity.getElement() == Element.PLOMB) damages += 10;
    //si l'élément du pokémon a une faiblesse sur celui du pokémon qui est attaqué alors les dégâts sont diminués de 10
    if(m_affinity.getWeakness() == pokemon.m_affinity.getElement() || m_affinity.getElement() == Element.ETHER) damages -= 10;
    if((damages - m_defense) > pokemon.m_hp) pokemon.m_hp = 0;
    else pokemon.m_hp -= (damages - m_defense);
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
  public int getSkillPoints()
  {
    return m_skillPoints;
  }

  public boolean isPoisoned()
  {
    return m_isPoisoned;
  }

  public boolean hasEffect()
  {
    return false;
  }

  
  //accesseurs
  public String getName()
  {
    return m_name;
  }

  public int getDefense()
  {
    return m_defense;
  }

  public void setDefense(int defense)
  {
      m_defense = defense;
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
  public void setHP(int hp)
  {
      m_hp = Math.min(hp, m_hpMax);
  }
  public void setAttack(int attack)
  {
    m_attack = attack;
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

  public void setSkillPoints(int skillPoints)
  {
      m_skillPoints = skillPoints;
  }

  public void setAffinity(Affinity affinity)
  {
    m_affinity = affinity;
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
