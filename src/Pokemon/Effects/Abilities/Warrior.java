package Effects.Abilities;
import Player.Player;
import Pokemon.Pokemon;
import Effects.EffectPokemon;
import Effects.EffectType;

public class Warrior extends EffectPokemon
{
    public Warrior(Pokemon caster)
    {
        super(Ability.WARRIOR_ZEAL, 1, caster, EffectType.START_TURN);
    }
    public void activate(Player currentPlayer, Player opponentPlayer)
    {
        Pokemon buffedPokemon = promptPokemon(currentPlayer.getField().getPokemons());
        buffedPokemon.setAttack(buffedPokemon.getAttack() + 10);
        target.add(buffedPokemon);
        setIsTriggered(true);
    }
    public void deactivate()
    {
        m_triggerCount = 0;
    }
}
