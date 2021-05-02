package combat.stats;

import java.util.HashMap;
import java.util.Map;

public class Stats implements Cloneable{
    private Map<Stat, Float> stats;

    public Stats(){
        stats = new HashMap<>();

        for(Stat stat : Stat.values())
            put(stat, 0f);
    }

    public void put(Stat stat, Float value){
        stats.put(stat, value);
        if(stat == Stat.CURRENT_HP && value < 0)
            stats.put(stat, 0f);
    }

    public void addModifier(Stat stat, Float value){
        put(stat, get(stat) + value);
    }

    public Float get(Stat stat){
        return stats.get(stat);
    }

    public Stats clone(){
        Stats clone = new Stats();
        for(Stat stat : stats.keySet())
            clone.put(stat, get(stat));
        return clone;
    }


    public static Stats ofHealthAndDamage(float health, float damage){
        Stats stats = new Stats();
        stats.put(Stat.MAX_HP, health);
        stats.put(Stat.CURRENT_HP, health);
        stats.put(Stat.ATTACK_DMG, damage);
        return stats;
    }
}
