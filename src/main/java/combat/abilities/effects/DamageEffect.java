package combat.abilities.effects;

import combat.stats.Stat;
import data.Mob;

public class DamageEffect implements Effect{

    private float damage;

    public DamageEffect(float damage){
        this.damage = damage;
    }

    public void execute(Mob attacker, Mob defender){
        float currentHp = defender.getStat(Stat.CURRENT_HP);
        float maxHp = defender.getStat(Stat.MAX_HP);

        if(currentHp - damage < 0)
            defender.setStat(Stat.CURRENT_HP, 0f);
        else defender.setStat(Stat.CURRENT_HP, Math.min(currentHp - damage, maxHp));
    }
}
