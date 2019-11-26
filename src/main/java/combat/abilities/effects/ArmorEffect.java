package combat.abilities.effects;

import combat.stats.Stat;
import data.Mob;

public class ArmorEffect implements Effect {

    private float armor;
    private int remainingDuration;
    private Mob subject;

    public ArmorEffect(float armor, int duration){
        this.armor = armor;
        this.remainingDuration = duration;
    }

    public void attach(Mob attacker, Mob defender) {
        this.subject = attacker;
        subject.applyEffect(this);
        execute();
    }

    public void execute() {
        subject.setStat(Stat.ARMOR, armor);
        subject.setStat(Stat.MAX_HP, subject.getStat(Stat.MAX_HP) + armor);
        remainingDuration--;
    }

    public void detach(){
        subject.setStat(Stat.ARMOR, Math.min(subject.getStat(Stat.ARMOR) - armor, 0));
        if(subject.getStat(Stat.ARMOR) < 0)
            subject.setStat(Stat.ARMOR, 0);

        subject.setStat(Stat.MAX_HP, subject.getStat(Stat.MAX_HP) - armor);
        subject.removeEffect(this);
    }

    public int getRemainingDuration(){
        return remainingDuration;
    }
}
