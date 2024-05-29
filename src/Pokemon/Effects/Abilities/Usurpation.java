package Pokemon.Effects.Abilities;

import Pokemon.Effects.Effect;
import Pokemon.Effects.Power;
import Pokemon.Effects.TargetType;
import Pokemon.Pokemon;
import Pokemon.PokemonWithPower;

public class Usurpation extends Effect
{
    public Usurpation()
    {
        super(Power.USURPATION, "" , TargetType.BOTH);
    }
    
    public Pokemon activate(PokemonWithPower p) 
    {
        //récupère le pouvoir d'un pokémon
        m_owner.setEffect(p.getEffect());
        m_owner.getEffect().useAgain();

        //retire le pouvoir à l'autre pokémon
        Pokemon pokemon = new Pokemon(p.getName(), p.getHP(), p.getAttack(), p.getAffinity());
        return pokemon;
    }    
}
