package Pokemon.Effects.Abilities;

import Pokemon.Effects.EffectPokemon;
import Pokemon.Effects.EffectType;
import Player.Player;
import Pokemon.Pokemon;

public class Resistance extends EffectPokemon {
    public Resistance(Pokemon caster){
        super(Ability.RESISTANCE,1,caster, EffectType.START_TURN);
    }

    public void activate(Player currentPlayer, Player opponentPlayer)
    {
        Pokemon buffedPokemon = promptPokemon(currentPlayer.getField().getPokemons());
        buffedPokemon.setDefense(buffedPokemon.getDefense() + 10);
        target.add(buffedPokemon);
    }
    public void deactivate()
    {
        m_triggerCount = 0;
    }
}
