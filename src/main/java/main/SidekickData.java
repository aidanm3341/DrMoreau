package main;

import combat.Attack;
import data.framework.BodyPart;
import data.framework.PartType;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import upgrade.bodyparts.*;
import util.CreatureComposer;
import util.SuperImage;

import java.util.HashMap;
import java.util.Map;

public class SidekickData {

    private Attack at1, at2, at3, at4, at5, at6;
    //private BodyPart head, armLeft, armRight, legLeft, legRight, tail, body;
    private Map<PartType, BodyPart> parts;
    private float currentHp, maxHP;
    private SuperImage image;

    public SidekickData() throws SlickException {
        parts = new HashMap<>();
        loadDefaultSidekick();
    }

    public void init(GameContainer gc) throws SlickException {
        image = new SuperImage();
    }

    public void putPart(PartType type, BodyPart part){
        parts.put(type, part);
        updateMaxHp();
    }

    public void updateMaxHp() {
        int newHp = 0;
        for(BodyPart part : parts.values())
            newHp += part.getHp();

        maxHP = newHp;
        currentHp = maxHP;
    }

    private void composeImage() {
        image = CreatureComposer.composeImage(((BodyConcreteBodyPart) parts.get(PartType.BODY)).getConnectors(),
                parts.get(PartType.HEAD),
                parts.get(PartType.LEFT_ARM),
                parts.get(PartType.RIGHT_ARM),
                parts.get(PartType.LEFT_LEG),
                parts.get(PartType.RIGHT_LEG),
                parts.get(PartType.TAIL),
                parts.get(PartType.BODY));
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

    public BodyPart getHead() {
        return parts.get(PartType.HEAD);
    }
    public BodyPart getArmLeft() {
        return parts.get(PartType.LEFT_ARM);
    }
    public BodyPart getArmRight() {
        return parts.get(PartType.RIGHT_ARM);
    }
    public BodyPart getLegLeft() {
        return parts.get(PartType.LEFT_LEG);
    }
    public BodyPart getLegRight() {
        return parts.get(PartType.RIGHT_LEG);
    }
    public BodyPart getTail() {
        return parts.get(PartType.TAIL);
    }
    public BodyPart getBody() {
        return parts.get(PartType.BODY);
    }

    public Map<PartType, BodyPart> getParts() {
        return parts;
    }

    public SuperImage getImage() {
        composeImage();
        return image;
    }
}
