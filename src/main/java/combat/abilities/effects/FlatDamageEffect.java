package combat.abilities.effects;

import combat.stats.Stat;

public class FlatDamageEffect extends Effect {

    private float damage;

    public FlatDamageEffect(float damage){
        this.damage = damage;
    }

    @Override
    public void firstAction() {
        defender.applyEffect(this);
        float currentHp = defender.getStat(Stat.CURRENT_HP);
        float armor = defender.getStat(Stat.ARMOR);
        float maxHp = defender.getStat(Stat.MAX_HP);

        if(armor - damage < 0) {
            defender.setStat(Stat.ARMOR, 0);
            damage = damage - armor;

            if(currentHp - damage < 0)
                defender.setStat(Stat.CURRENT_HP, 0f);
            else
                defender.setStat(Stat.CURRENT_HP, Math.min(currentHp - damage, maxHp));
        }
        else {
            defender.setStat(Stat.ARMOR, armor - damage);
        }
    }

    @Override
    public void endOfTurnAction() { }

    @Override
    public int getRemainingDuration() {
        return 0;
    }

    @Override
    public boolean isComplete() {
        return getRemainingDuration() <= 0;
    }

    public String toString(){
        return damage + " damage";
    }
}
