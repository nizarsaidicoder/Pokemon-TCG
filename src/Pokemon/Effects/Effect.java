package Effects;

import Effects.Abilities.Ability;
import Pokemon.Pokemon;

import java.util.Scanner;

abstract public class Effect  implements Triggerable
{
    protected Ability m_ability;
    protected int m_triggerCount;
    // effect type is used to determine if the effect get triggered in the beginning of the turn or the end of the turn
    protected EffectType m_effectType;
    protected Pokemon m_caster;
    protected boolean m_isTriggered = false;
    protected Scanner m_scanner = new Scanner(System.in);

    public Effect(Ability ability, int triggerCount, Pokemon caster, EffectType effectType)
    {
        m_ability = ability;
        m_triggerCount = triggerCount;
        m_caster = caster;
        m_effectType = effectType;
    }
    public boolean getIsTriggered()
    {
        return m_isTriggered;
    }
    public void setIsTriggered(boolean isTriggered)
    {
        m_isTriggered = isTriggered;
    }
    public Ability getAbility()
    {
        return m_ability;
    }
    public int getTriggerCount()
    {
        return m_triggerCount;
    }
    public Pokemon getCaster()
    {
        return m_caster;
    }
    public EffectType getEffectType()
    {
        return m_effectType;
    }
}
