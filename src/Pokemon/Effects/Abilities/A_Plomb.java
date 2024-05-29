package Pokemon.Effects.Abilities;

import Pokemon.Effects.Effect;
import Pokemon.Effects.Power;
import Pokemon.Effects.TargetType;
import Pokemon.Pokemon;
import Pokemon.PokemonWithPower;

public class A_Plomb extends Effect
{
    public A_Plomb()
    {
        super(Power.PLOMB, "" , TargetType.BOTH);
    }
    
    public void activate(PokemonWithPower p) 
    {
       p.setAffinity(new Plomb());
       m_used = true;
    }    
}
