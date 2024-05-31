package Pokemon.Effects.Abilities;

import Pokemon.Effects.Effect;
import Pokemon.Effects.Power;
import Pokemon.Effects.TargetType;
import Pokemon.Pokemon;

public class SoinTotal extends Effect
{
    public SoinTotal()
    {
        super(Power.SOIN_TOTAL,"Upon use, the Pokémon with this current effect can select an ally (including itself). The chosen Pokémon fully recovers all its health." , TargetType.ALLY);
    }

    public void activate(Pokemon p) 
    {
        //récupère toute sa vie
        p.setHP(p.getHPMax());    
        m_used = true;
    }
    
}
