package combat;

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
        stats = new Stats();
        for(BodyPart part : parts.values()) {
            Stats partStats = part.getStats();
            stats.addModifer(Stat.MAX_HP, partStats.get(Stat.MAX_HP));
            stats.addModifer(Stat.CURRENT_HP, partStats.get(Stat.CURRENT_HP));
            stats.addModifer(Stat.ATTACK_DMG, partStats.get(Stat.ATTACK_DMG));
            stats.addModifer(Stat.DEFENCE, partStats.get(Stat.DEFENCE));
        }

        this.parts = parts;
    }

    public String getName(){return name;}

    public void setHp(float dmgDealt){
        float currentHp = stats.get(Stat.CURRENT_HP);
        float maxHp = stats.get(Stat.MAX_HP);

        if(currentHp - dmgDealt < 0)
            stats.put(Stat.CURRENT_HP, 0f);
        else if(currentHp - dmgDealt > maxHp)
            stats.put(Stat.CURRENT_HP, maxHp);
        else
            stats.put(Stat.CURRENT_HP, currentHp - dmgDealt);
    }

    public float getStat(Stat stat){
        return stats.get(stat);
    }

    public Map<PartType, BodyPart> getParts() {
        return parts;
    }
}
