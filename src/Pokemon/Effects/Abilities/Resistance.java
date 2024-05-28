package Pokemon.Effects.Abilities;

import Pokemon.Effects.Effect;
import Pokemon.Effects.Power;
import Pokemon.Effects.TargetType;
import Pokemon.Pokemon;

public class Resistance extends Effect
{
    public Resistance()
    {
        super(Power.RESISTANCE,"Upon use, the Pokémon with this current effect can select an ally (including itself). Until the end of the battle or the death of the chosen Pokémon, that Pokémon takes 10 less damage from each attack.", TargetType.ALLY);
    }
    //augmente la défense du pokémon de 10
    public void activate(Pokemon p) 
    {
        p.setDefense(p.getDefense() + 10);
        m_used = true;
    }
}
