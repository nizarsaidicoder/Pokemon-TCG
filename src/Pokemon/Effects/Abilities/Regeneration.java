package Pokemon.Effects.Abilities;

import Pokemon.Effects.Effect;
import Pokemon.Effects.Power;
import Pokemon.Effects.TargetType;
import Pokemon.Pokemon;
import Pokemon.PokemonWithPower;

public class Regeneration extends Effect
{
    public Regeneration()
    {
        super(Power.REGENERATION, "Upon use, the Pokémon with this current effect can select an ally. If the chosen Pokémon has already used a single-use ability, it can use it a second time.", TargetType.ALLY);
    }

    public void activate(Pokemon p) 
    {
        if(p.hasEffect())
        {
            PokemonWithPower pwp = (PokemonWithPower)p;
            //régénère le pouvoir du pokémon
            if(pwp.getEffect().isUsed())
            {
                pwp.getEffect().useAgain();
            }
        }
        m_used = true;
    }    
}
