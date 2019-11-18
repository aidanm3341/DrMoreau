package combat;

import combat.stats.Stat;
import data.framework.BodyPart;
import data.framework.PartType;

import java.util.HashMap;
import java.util.Map;

public class Mob {

    private String name;
    private Map<Stat, Integer> stats;
    private Map<PartType, BodyPart> parts;

    public Mob(String name, int hp, int attStat, int defStat, Map<PartType, BodyPart> parts) {
        this.name = name;
        stats = new HashMap<>();
        stats.put(Stat.MAX_HP, hp);
        stats.put(Stat.CURRENT_HP, hp);
        stats.put(Stat.ATTACK_DMG, attStat);
        stats.put(Stat.DEFENCE, defStat);

        this.parts = parts;
    }

    public String getName(){return name;}

    public void setHp(int dmgDealt){
        int currentHp = stats.get(Stat.CURRENT_HP);
        int maxHp = stats.get(Stat.MAX_HP);

        if(currentHp - dmgDealt < 0)
            stats.put(Stat.CURRENT_HP, 0);
        else if(currentHp - dmgDealt > maxHp)
            stats.put(Stat.CURRENT_HP, maxHp);
        else
            stats.put(Stat.CURRENT_HP, currentHp - dmgDealt);
    }

    public float getCurrentHp(){
        return stats.get(Stat.CURRENT_HP);
    }

    public float getMaxHp() {
        return stats.get(Stat.MAX_HP);
    }

    public float getAttStat(){
        return stats.get(Stat.ATTACK_DMG);
    }

    public Map<PartType, BodyPart> getParts() {
        return parts;
    }
}
