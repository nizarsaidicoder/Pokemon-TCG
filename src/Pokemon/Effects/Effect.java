package Pokemon.Effects;

import Pokemon.Pokemon;

public abstract class Effect 
{

    private Power m_power;
    private String m_description;
    private TargetType m_targetType;
    protected Pokemon m_owner;
    protected Boolean m_used = false;
    public Effect(Power power, String description, TargetType targetType)
    {
        m_power = power;
        m_description = description;
        m_targetType = targetType;
    }

    public Power getPower()
    {
        return m_power;
    }

    public TargetType getTargetType()
    {
        return m_targetType;
    }
    public Boolean isUsed()
    {
        return m_used;
    }
    public String getDescription()
    {
        return m_description;
    }
    
    public void setOwner(Pokemon p)
    {
        m_owner = p;
    }

    public void useAgain()
    {
        m_used = false;
    }
    
    public Pokemon getPokemon()
    {
        return m_owner;
    }

    //public abstract void activate(Pokemon p);

    
}
