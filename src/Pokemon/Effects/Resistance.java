package Pokemon.Effects;

import Pokemon.Pokemon;

public class Resistance extends Effect
{
    public Resistance(Power power, TargetType target)
    {
        super(power, target);
    }
    
    //augmente la défense du pokémon de 10
    public void activate(Pokemon p) 
    {
        p.setDefense(p.getDefense() + 10);
    }
}
