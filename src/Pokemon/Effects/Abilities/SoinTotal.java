package Pokemon.Effects.Abilities;

import Pokemon.Effects.Effect;
import Pokemon.Effects.Power;
import Pokemon.Effects.TargetType;
import Pokemon.Pokemon;

public class SoinTotal extends Effect
{
    public SoinTotal()
    {
        super(Power.SOIN_TOTAL,"" , TargetType.ALLY);
    }

    public void activate(Pokemon p) 
    {
        //récupère toute sa vie
        p.setHP(p.getHPMax());    
    }
    
}
