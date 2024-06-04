package Pokemon.Effects.Abilities;

import Pokemon.Effects.Effect;
import Pokemon.Effects.Power;
import Pokemon.Effects.TargetType;
import Pokemon.Pokemon;

public class DejaVu extends Effect
{
    public DejaVu()
    {
        super(Power.DEJA_VU, "Upon use, the Pokémon with this current effect can select an ally (including itself). The chosen Pokémon can act a second time during the current turn.", TargetType.ALLY);
    }

    public void activate(Pokemon p) 
    {
        //le pokémon peut rejouer
        p.setAttackPoints(p.getAttackPoints() + 1);
        m_used = true; 
    }    
}
