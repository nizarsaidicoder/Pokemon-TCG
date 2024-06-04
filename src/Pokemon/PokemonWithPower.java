package Pokemon;

import Pokemon.Effects.*;
import Pokemon.Affinity.*;

public class PokemonWithPower extends Pokemon
{
    // Le pouvoir du pokémon
    private Effect m_effect;

    /**
     * Constructeur
     * @param name nom du pokémon
     * @param hp points de vie
     * @param attack points d'attaque
     * @param affinity affinité
     * @param effect pouvoir
     */
    public PokemonWithPower(String name, int hp, int attack, Affinity affinity, Effect effect)
    {
        super(name, hp, attack, affinity);
        m_effect = effect;
        effect.setOwner(this);
    }

    /**
     * Active l'effet du pouvoir
     * @param target cible de l'effet
     */
    public void activateEffect(Pokemon target)
    {
        m_effect.activate(target);
    }
    @Override
    public boolean hasEffect() {
        return true;
    }
    /**
     * Setter de l'effet
     * @param effect
     */
    // Getters et Setters
    public void setEffect(Effect effect)
    {
        m_effect = effect;
    }
    /**
     * Getter de l'effet
     * @return
     */
    public Effect getEffect()
    {
        return m_effect;
    }
    
}
