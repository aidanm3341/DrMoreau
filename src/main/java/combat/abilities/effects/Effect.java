package combat.abilities.effects;

import data.mob.MobCombatData;

public abstract class Effect implements IEffect{

    protected MobCombatData attacker, defender;

    @Override
    public final void attach(MobCombatData attacker, MobCombatData defender) {
        this.attacker = attacker;
        this.defender = defender;
        firstAction();
    }
}
