package Pokemon.Effects.Abilities;

import Pokemon.Affinity.*;
import Pokemon.Effects.Effect;
import Pokemon.Effects.Power;
import Pokemon.Effects.TargetType;
import Pokemon.Pokemon;

public class A_Plomb extends Effect
{
    public A_Plomb()
    {
        super(Power.PLOMB, "Plomb Affinity: Upon use, the Pokémon with this current effect can select an opposing Pokémon. The chosen Pokémon changes its affinity to Plomb. Lead is a new element that all other elements have an advantage over." , TargetType.ENEMY);
    }
    
    public void activate(Pokemon p) 
    {
       p.setAffinity(new Plomb());
       m_used = true;
    }    
}
