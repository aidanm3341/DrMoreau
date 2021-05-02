package combat.abilities.effects;

import combat.stats.Stat;
import data.mob.MobCombatData;

public class SummedDamageEffect implements Effect{

    private float damage;
    private MobCombatData subject;

    public SummedDamageEffect(){ }

    public void attach(MobCombatData attacker, MobCombatData defender) {
        this.subject = defender;
        subject.applyEffect(this);

        this.damage = attacker.getStat(Stat.ATTACK_DMG);

        onAttach();
    }

    public void onAttach() {
        float currentHp = subject.getStat(Stat.CURRENT_HP);
        float armor = subject.getStat(Stat.ARMOR);
        float maxHp = subject.getStat(Stat.MAX_HP);

        if(armor - damage < 0) {
            subject.setStat(Stat.ARMOR, 0);
            damage = damage - armor;

            if(currentHp - damage < 0)
                subject.setStat(Stat.CURRENT_HP, 0f);
            else
                subject.setStat(Stat.CURRENT_HP, Math.min(currentHp - damage, maxHp));
        }
        else{
            subject.setStat(Stat.ARMOR, armor - damage);
        }
    }

    public void resolveEndOfTurn(){}

    public int getRemainingDuration(){
        return 0;
    }

    @Override
    public boolean isComplete() {
        return this.getRemainingDuration() <= 0;
    }

    public String toString(){
        return damage + " damage";
    }
}
