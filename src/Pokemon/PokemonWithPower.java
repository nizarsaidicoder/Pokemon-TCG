package Pokemon;

import Pokemon.Effects.*;
import Pokemon.Affinity.*;

public class PokemonWithPower extends Pokemon
{
    private Effect m_effect;

    public PokemonWithPower(String name, int hp, int attack, Affinity affinity, Effect effect)
    {
        super(name, hp, attack, affinity);
        m_effect = effect;
    }

    @Override
    public boolean hasEffect() {
        return true;
    }

    public Effect getEffect()
    {
        return m_effect;
    }

    @Override
    /**
     * Affichage pokémon
     * @return "<nom>, <affinité>, HP : <hp>, Attack : <attaque>"
     */
    public String toString()
    {
      return super.toString() + String.format(", Power : %s", m_effect.getPower());
    }
    
}
