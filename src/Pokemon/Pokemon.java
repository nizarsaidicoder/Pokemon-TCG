package Pokemon;

public class Pokemon
{
  private String m_name;
  private int m_hp;
  private int m_hpMax;
  private int m_attack;
  private String m_affinity;

  //constructeur
  public Pokemon(String name, int hp, int hpMax, int attack, String affinity)
  {
    m_name = name;
    m_hp = hp;
    m_hpMax = hpMax;
    m_attack = attack;
    m_affinity = affinity;

  }

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

  //accesseurs
  public String getName()
  {
    return m_name;
  }
  public int getHP()
  {
      return m_hp;
  }
  public int getHPMax()
  {
      return m_hpMax;
  }
  public int getAttack()
  {
      return m_attack;
  }
  public String getAffinity()
  {
      return m_affinity;
  }

  @Override
  public String toString()
  {
    return String.format("%s, %s, HP : %d, Attack : %d", m_name, m_affinity, m_hp, m_attack);
  }

}
