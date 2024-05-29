package Pokemon.Effects.Abilities;

import Pokemon.Effects.Effect;
import Pokemon.Effects.Power;
import Pokemon.Effects.TargetType;
import Pokemon.Pokemon;

public class DejaVu extends Effect
{
    public DejaVu()
    {
        super(Power.DEJA_VU, "", TargetType.ALLY);
    }

    public void activate(Pokemon p) 
    {
        //le pokémon peut rejouer
        p.setSkillPoints(p.getSkillPoints() + 1);
        m_used = true; 
    }    
}
