package Pokemon.Effects.Abilities;

import Pokemon.Affinity.*;
import Pokemon.Effects.Effect;
import Pokemon.Effects.Power;
import Pokemon.Effects.TargetType;
import Pokemon.Pokemon;

public class A_Ether extends Effect
{
    public A_Ether()
    {
        super(Power.ETHER, "Upon use, the Pokémon with this current effect can select an ally (including itself). The chosen Pokémon changes its affinity to Ether. Ether is a new element that has an advantage over all other elements.", TargetType.ALLY);
    }

    public void activate(Pokemon p) 
    {
        p.setAffinity(new Ether());
        m_used = true; 
    }
}
