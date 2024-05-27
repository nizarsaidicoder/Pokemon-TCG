package Pokemon.Effects;
import Pokemon.Pokemon;

public abstract class Effect 
{

    private Power m_power;
    private TargetType m_targetType;
    private Boolean m_used = false;

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

    public abstract void activate(Pokemon p);

    
}
