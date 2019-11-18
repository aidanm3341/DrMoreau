package main;

import combat.Attack;
import combat.stats.Stat;
import combat.stats.Stats;
import data.framework.BodyPart;
import data.framework.PartType;
import org.newdawn.slick.SlickException;
import data.bodyparts.*;

import java.util.HashMap;
import java.util.Map;

public class SidekickData {

    private Map<PartType, BodyPart> parts;
    private Stats stats;

    public SidekickData() throws SlickException {
        parts = new HashMap<>();
        stats = new Stats();
        loadDefaultSidekick();
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


    public void attack(float dmg){
        if(stats.get(Stat.CURRENT_HP) - dmg < 0)
            stats.put(Stat.CURRENT_HP, 0f);
        else
            stats.put(Stat.CURRENT_HP, (stats.get(Stat.CURRENT_HP) - dmg));
    }

    public void loadDefaultSidekick() throws SlickException {
        putPart(PartType.BODY, PartFactory.getPart("dog_body", 2));
        putPart(PartType.LEFT_ARM, PartFactory.getPart("dog_arm", 2));
        putPart(PartType.RIGHT_ARM, PartFactory.getPart("dog_arm", 2));
        putPart(PartType.LEFT_LEG, PartFactory.getPart("dog_leg", 2));
        putPart(PartType.RIGHT_LEG, PartFactory.getPart("dog_leg", 2));
        putPart(PartType.TAIL, PartFactory.getPart("dog_tail", 2));
        putPart(PartType.HEAD, PartFactory.getPart("dog_head", 2));
    }

    public float getMaxHp(){
        return stats.get(Stat.MAX_HP);
    }

    public float getCurrentHp() {
        return stats.get(Stat.CURRENT_HP);
    }

    public float getStat(Stat stat){
        return stats.get(stat);
    }

    public Map<PartType, BodyPart> getParts() {
        return parts;
    }
}
