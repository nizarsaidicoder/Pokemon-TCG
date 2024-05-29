package Pokemon.Effects.Abilities;
import Pokemon.Affinity.Plomb;
import Pokemon.Effects.Effect;
import Pokemon.Effects.Power;
import Pokemon.Effects.TargetType;
import Pokemon.PokemonWithPower;

public class A_Plomb extends Effect
{
    public A_Plomb()
    {
        super(Power.PLOMB, "" , TargetType.ENEMY);
    }
    
    public void activate(PokemonWithPower p) 
    {
       p.setAffinity(new Plomb());
       m_used = true;
    }    
}
