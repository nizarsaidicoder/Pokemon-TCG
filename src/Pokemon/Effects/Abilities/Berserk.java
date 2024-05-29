package Pokemon.Effects.Abilities;

import Pokemon.Effects.Effect;
import Pokemon.Effects.Power;
import Pokemon.Effects.TargetType;
import Pokemon.Pokemon;

public class Berserk extends Effect
{
    public Berserk()
    {
        super(Power.BERSERK, "", TargetType.ALLY);
    }

    public void activate(Pokemon p) 
    {
        //double l'attaque du pokémon
        p.setAttack(p.getAttack() * 2);
        m_used = true;
    }
}
