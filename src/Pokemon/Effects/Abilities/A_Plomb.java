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
        super(Power.PLOMB, "" , TargetType.ENEMY);
    }
    
    public void activate(Pokemon p) 
    {
       p.setAffinity(new Plomb());
       m_used = true;
    }    
}
