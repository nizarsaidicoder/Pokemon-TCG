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
        super(Power.ETHER, "", TargetType.ALLY);
    }

    public void activate(Pokemon p) 
    {
        p.setAffinity(new Ether());
        m_used = true; 
    }
}
