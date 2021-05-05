package combat.abilities.effects;

import combat.stats.Stat;

public class PoisonEffect extends Effect{

    private final float dmgPerTurn;
    private int duration;

    public PoisonEffect(float dmgPerTurn, int duration){
        this.dmgPerTurn = dmgPerTurn;
        this.duration = duration;
    }

    @Override
    public void firstAction() {
        defender.applyEffect(this);
    }

    @Override
    public void endOfTurnAction() {
        defender.setStat(Stat.CURRENT_HP, defender.getStat(Stat.CURRENT_HP) - dmgPerTurn);
        duration--;
    }

    @Override
    public int getRemainingDuration() {
        return duration;
    }

    @Override
    public boolean isComplete() {
        return getRemainingDuration() <= 0;
    }

    @Override
    public String toString() {
        return dmgPerTurn + " poison, for " + duration + " turns";
    }
}
