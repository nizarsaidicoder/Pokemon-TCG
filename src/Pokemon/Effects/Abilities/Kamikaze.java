package Pokemon.Effects.Abilities;

import Pokemon.Effects.Effect;
import Pokemon.Effects.Power;
import Pokemon.Effects.TargetType;
import Pokemon.Pokemon;

public class Kamikaze extends Effect
{
    public Kamikaze()
    {
        super(Power.KAMIKAZE, "Upon use, the Pokémon with this current effect can select an opposing Pokémon. Both the chosen Pokémon and the user's Pokémon are eliminated.", TargetType.ENEMY);
    }
    
    public void activate(Pokemon p) 
    {
        //le pokémon adverse et lui même sont éliminés
        m_owner.setHP(0);
        p.setHP(0);
        m_used = true;
    }
}
