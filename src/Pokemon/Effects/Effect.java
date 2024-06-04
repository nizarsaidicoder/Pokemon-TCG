package Pokemon.Effects;

import Pokemon.Pokemon;
import Pokemon.PokemonWithPower;

public abstract class Effect 
{

    private Power m_power;
    private String m_description;
    private TargetType m_targetType;
    protected PokemonWithPower m_owner;
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
    /**
     * Methode pour obtenir le type de cible de l'effet
     * @return le type de cible de l'effet
     */
    public TargetType getTargetType()
    {
        return m_targetType;
    }
    /** 
     * Methode pour savoir si l'effet a déjà été utilisé
     */
    public Boolean isUsed()
    {
        return m_used;
    }
    public String getDescription()
    {
        return m_description;
    }
    /**
     * Methode pour définir le propriétaire de l'effet
     * @param p
     */
    public void setOwner(PokemonWithPower p)
    {
        m_owner = p;
    }
    /**
     * Methode pour réactiver l'effet
     */
    public void useAgain()
    {
        m_used = false;
    }

    public Pokemon getPokemon()
    {
        return m_owner;
    }
    /**
     * Active l'effet sur le pokémon
     * @param p pokémon sur lequel activer l'effet
     */
    public abstract void activate(Pokemon p);

    
}
