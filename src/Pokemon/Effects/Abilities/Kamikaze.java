package Pokemon.Effects.Abilities;

import Pokemon.Effects.Effect;
import Pokemon.Effects.Power;
import Pokemon.Effects.TargetType;
import Pokemon.Pokemon;

public class Kamikaze extends Effect
{
    public Kamikaze()
    {
        super(Power.KAMIKAZE, "", TargetType.BOTH);
    }
    
    public void activate(Pokemon p) 
    {
        //le pokémon adverse et lui même sont éliminés
        m_owner.setHP(0);
        p.setHP(0);
        m_used = true;
    }
}
