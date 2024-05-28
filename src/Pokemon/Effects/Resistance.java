package Pokemon.Effects;

import Pokemon.Pokemon;

public class Resistance extends Effect
{
    public Resistance()
    {
        super(Power.RESISTANCE, TargetType.ALLY);
    }
    
    //augmente la défense du pokémon de 10
    public void activate(Pokemon p) 
    {
        p.setDefense(p.getDefense() + 10);
    }
}
