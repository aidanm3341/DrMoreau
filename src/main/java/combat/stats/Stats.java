package combat.stats;

import java.util.HashMap;
import java.util.Map;

public class Stats implements Cloneable{
    private Map<Stat, Integer> stats;

    public Stats(){
        stats = new HashMap<>();
        for(Stat stat : Stat.values())
            stats.put(stat, 0);
    }

    public void put(Stat stat, Integer value){
        stats.put(stat, value);
    }

    public void addModifer(Stat stat, Integer value){
        stats.put(stat, stats.get(stat) + value);
    }

    public Integer get(Stat stat){
        return stats.get(stat);
    }

    public Stats clone(){
        Stats clone = new Stats();
        for(Stat stat : stats.keySet())
            clone.put(stat, stats.get(stat));
        return clone;
    }
}
