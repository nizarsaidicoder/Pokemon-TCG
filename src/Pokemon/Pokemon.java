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
  private int m_defense;
  private Affinity m_affinity;
  private int m_attackPoints;

  //constructeur
  public Pokemon(String name, int hp, int attack, Affinity affinity)
  {
    m_name = name;
    m_hp = hp;
    m_hpMax = hp;
    m_attack = attack;
    m_defense = 0;
    m_affinity = affinity;
    m_attackPoints = 0;
  }
  /**
   * Attaque un autre pokémon avec gestion de l'affinité
   * @param pokemon pokémon qui reçoit les dégâts
   */
  public void attack(Pokemon pokemon)
  {
    int damages = m_attack;
    //si l'élément du pokémon a un avantage sur celui du pokémon qui est attaqué alors les dégâts sont augmentés de 10
    if(m_affinity.getStrength() == pokemon.m_affinity.getElement() || m_affinity.getElement() == Element.ETHER) damages += 10;
    //si l'élément du pokémon a une faiblesse sur celui du pokémon qui est attaqué alors les dégâts sont diminués de 10
    if(m_affinity.getWeakness() == pokemon.m_affinity.getElement() || m_affinity.getElement() == Element.PLOMB) damages -= 10;
    //si les dégâts sont négatifs alors ils sont mis à 0
    if((damages - m_defense) > pokemon.m_hp) pokemon.m_hp = 0;
    else pokemon.m_hp -= (damages - m_defense);
    m_attackPoints--;
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
  /**
   * Méthode pour vérifier si le pokémon a un effet
   * @return
   */
  public boolean hasEffect()
  {
    return false;
  }
  /**
    * Getter pour vérifier si le pokemon a des points d'attaque disponibles
    * @return points d'attaque
   */
  public int getAttackPoints()
  {
    return m_attackPoints;
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
  // mutateurs
  public void setDefense(int defense)
  {
    m_defense = defense;
  }

  public void setHP(int hp)
  {
      m_hp = Math.min(hp, m_hpMax);
  }
  public void setAttack(int attack)
  {
    m_attack = attack;
  }

  public void setAttackPoints(int skillPoints)
  {
      m_attackPoints = skillPoints;
  }

  public void setAffinity(Affinity affinity)
  {
    m_affinity = affinity;
  }
}
