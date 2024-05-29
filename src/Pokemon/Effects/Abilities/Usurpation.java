package Pokemon.Effects.Abilities;

import Pokemon.Effects.Effect;
import Pokemon.Effects.Power;
import Pokemon.Effects.TargetType;
import Pokemon.PokemonWithPower;

public class Usurpation extends Effect
{
    public Usurpation()
    {
        super(Power.USURPATION, "" , TargetType.BOTH);
    }
    
    public void activate(PokemonWithPower p) 
    {
        //
    }    
}
