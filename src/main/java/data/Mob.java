package data;

import combat.stats.Stat;
import combat.stats.Stats;
import data.framework.BodyPart;
import data.framework.PartType;

import java.util.HashMap;
import java.util.Map;

public class Mob {

    private String name;
    private Stats stats;
    private Map<PartType, BodyPart> parts;

    public Mob(String name, Map<PartType, BodyPart> parts) {
        this.name = name;
        this.parts = parts;

        stats = new Stats();
        for(BodyPart part : parts.values()) {
            Stats partStats = part.getStats();
            for(Stat stat : Stat.values())
                stats.addModifer(stat, partStats.get(stat));
        }
    }

    public String getName(){return name;}

    public void attack(float dmgDealt){
        float currentHp = stats.get(Stat.CURRENT_HP);
        float maxHp = stats.get(Stat.MAX_HP);

        if(currentHp - dmgDealt < 0)
            stats.put(Stat.CURRENT_HP, 0f);
        else stats.put(Stat.CURRENT_HP, Math.min(currentHp - dmgDealt, maxHp));
    }

    public void putPart(PartType type, BodyPart part){
        parts.put(type, part);
        updateMaxHp();
    }

    private void updateMaxHp() {
        float newHp = 0;
        for(BodyPart part : parts.values())
            newHp += part.getStats().get(Stat.MAX_HP);

        stats.put(Stat.MAX_HP, newHp);
        stats.put(Stat.CURRENT_HP, newHp);
    }

    public float getStat(Stat stat){
        return stats.get(stat);
    }

    public BodyPart getPart(PartType part){
        return parts.get(part);
    }
}
