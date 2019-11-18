package main;

import combat.Attack;
import combat.stats.Stat;
import data.framework.BodyPart;
import data.framework.PartType;
import org.newdawn.slick.SlickException;
import upgrade.bodyparts.*;

import java.util.HashMap;
import java.util.Map;

public class SidekickData {

    private Map<PartType, BodyPart> parts;
    private float currentHp, maxHP;

    public SidekickData() throws SlickException {
        parts = new HashMap<>();
        loadDefaultSidekick();
    }

    public void putPart(PartType type, BodyPart part){
        parts.put(type, part);
        updateMaxHp();
    }

    private void updateMaxHp() {
        int newHp = 0;
        for(BodyPart part : parts.values())
            newHp += part.getStats().get(Stat.MAX_HP);

        maxHP = newHp;
        currentHp = maxHP;
    }


    public void attack(float dmg){
        if(currentHp - dmg < 0)
            currentHp = 0;
        else
            currentHp -= dmg;
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
        return maxHP;
    }

    public float getCurrentHp() {
        return currentHp;
    }

    public Attack getAt1() {
        return parts.get(PartType.HEAD).getAttack();
    }
    public Attack getAt2() {
        return parts.get(PartType.LEFT_LEG).getAttack();
    }
    public Attack getAt3() {
        return parts.get(PartType.RIGHT_LEG).getAttack();
    }
    public Attack getAt4() {
        return parts.get(PartType.LEFT_ARM).getAttack();
    }
    public Attack getAt5() {
        return parts.get(PartType.RIGHT_ARM).getAttack();
    }
    public Attack getAt6() {
        return parts.get(PartType.TAIL).getAttack();
    }

    public Map<PartType, BodyPart> getParts() {
        return parts;
    }
}
