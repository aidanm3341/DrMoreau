package combat.abilities.effects;

import combat.stats.Stat;
import data.mob.MobCombatData;

public class FlatDamageEffect implements Effect{

    private final float damage;

    public FlatDamageEffect(float damage){
        this.damage = damage;
    }

    @Override
    public void attach(MobCombatData attacker, MobCombatData defender) {
        defender.applyEffect(this);
        defender.setStat(Stat.CURRENT_HP, defender.getStat(Stat.CURRENT_HP) - damage);
    }

    @Override
    public void resolveEndOfTurn() { }

    @Override
    public int getRemainingDuration() {
        return 0;
    }

    @Override
    public boolean isComplete() {
        return getRemainingDuration() <= 0;
    }
}
