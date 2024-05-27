package Pokemon.Effects;

import Pokemon.Effects.Abilities.Ability;
import Player.Player;
import Pokemon.Pokemon;

abstract public class EffectPlayer extends Effect{

    protected Player target;
    public EffectPlayer(Ability ability, int triggerCount, Pokemon caster, EffectType effectType)
    {
        super(ability, triggerCount, caster, effectType);
    }
    public Player getTarget()
    {
        return target;
    }
}
