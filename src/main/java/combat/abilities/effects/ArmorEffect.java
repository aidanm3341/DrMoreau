package combat.abilities.effects;

import combat.stats.Stat;
import data.mob.MobCombatData;

public class ArmorEffect extends Effect {

    private final float armor;

    public ArmorEffect(float armor){
        this.armor = armor;
    }

    @Override
    public void firstAction() {
        attacker.applyEffect(this);
        attacker.setStat(Stat.ARMOR, armor);
    }

    public void endOfTurnAction() {
        attacker.setStat(Stat.ARMOR, Math.min(attacker.getStat(Stat.ARMOR) - armor, 0));
        if(attacker.getStat(Stat.ARMOR) < 0)
            attacker.setStat(Stat.ARMOR, 0);
    }

    public int getRemainingDuration(){
        return 0;
    }

    @Override
    public boolean isComplete() {
        return this.getRemainingDuration() <= 0;
    }

    public String toString(){
        return armor + " armor";
    }
}
