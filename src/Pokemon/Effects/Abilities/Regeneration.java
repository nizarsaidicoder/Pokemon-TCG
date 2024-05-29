package Pokemon.Effects.Abilities;

import Pokemon.Effects.Effect;
import Pokemon.Effects.Power;
import Pokemon.Effects.TargetType;
import Pokemon.PokemonWithPower;

public class Regeneration extends Effect
{
    public Regeneration()
    {
        super(Power.REGENERATION, "", TargetType.ALLY);
    }

    public void activate(PokemonWithPower p) 
    {
        //régénère le pouvoir du pokémon
        if(p.getEffect().isUsed())
        {
            p.getEffect().useAgain();
        }
        m_used = true;
    }    
}
