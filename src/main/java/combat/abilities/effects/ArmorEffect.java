package combat.abilities.effects;

import combat.stats.Stat;
import data.mob.MobCombatData;

public class ArmorEffect implements Effect {

    private float armor;
    private int remainingDuration;
    private MobCombatData subject;

    public ArmorEffect(float armor, int duration){
        this.armor = armor;
        this.remainingDuration = duration;
    }

    public void attach(MobCombatData attacker, MobCombatData defender) {
        this.subject = attacker;
        subject.applyEffect(this);
        onAttach();
    }

    public void onAttach() {
        subject.setStat(Stat.ARMOR, armor);
    }

    public void resolveEndOfTurn() {
        subject.setStat(Stat.ARMOR, Math.min(subject.getStat(Stat.ARMOR) - armor, 0));
        if(subject.getStat(Stat.ARMOR) < 0)
            subject.setStat(Stat.ARMOR, 0);

        remainingDuration--;
    }

    public int getRemainingDuration(){
        return remainingDuration;
    }

    @Override
    public boolean isComplete() {
        return this.getRemainingDuration() <= 0;
    }
}
