package main;

import combat.Attack;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import upgrade.bodyparts.*;
import util.CreatureComposer;
import util.SuperImage;

public class SidekickData {

    private Attack at1, at2, at3, at4, at5, at6;
    private AbstractBodyPart head, armLeft, armRight, legLeft, legRight, tail, body;
    private float currentHp, maxHP;
    private SuperImage image;

    public SidekickData(){

    }

    public void init(GameContainer gc) throws SlickException {

        head = new NullBodyPart();
        armLeft = new NullBodyPart();
        armRight = new NullBodyPart();
        legLeft = new NullBodyPart();
        legRight = new NullBodyPart();
        tail = new NullBodyPart();
        body = new NullBodyPart();

        image = new SuperImage();

        loadDefaultSidekick();
    }

    public void loadDefaultSidekick() throws SlickException
    {
        addBody(PartFactory.getPart("dog_body", 1));
        addLegLeft(PartFactory.getPart("dog_leg", 1));
        addArmLeft(PartFactory.getPart("dog_arm", 1));
        addLegRight(PartFactory.getPart("dog_leg", 1));
        addArmRight(PartFactory.getPart("dog_arm", 1));
        addTail(PartFactory.getPart("dog_tail", 1));
        addHead(PartFactory.getPart("dog_head", 1));
    }

    
    public void addBody(AbstractBodyPart newPart){
        body = newPart;
        updateMaxHp();
    }
    public void addHead(AbstractBodyPart newPart){
        head = newPart;
        at1 = head.getAttack();
        updateMaxHp();
    }
    public void addLegLeft(AbstractBodyPart newPart){
        legLeft = newPart;
        at2 = legLeft.getAttack();
        updateMaxHp();
    }
    public void addLegRight(AbstractBodyPart newPart){
        legRight = newPart;
        at3 = legRight.getAttack();
        updateMaxHp();
    }
    public void addArmLeft(AbstractBodyPart newPart){
        armLeft = newPart;
        at4 = armLeft.getAttack();
        updateMaxHp();
    }
    public void addArmRight(AbstractBodyPart newPart){
        armRight = newPart;
        at5 = armRight.getAttack();
        updateMaxHp();
    }
    public void addTail(AbstractBodyPart newPart){
        tail = newPart;
        at6 = tail.getAttack();
        updateMaxHp();
    }

    public void updateMaxHp() {
        int newHp = 0;
        newHp += body.getHp();
        newHp += head.getHp();
        newHp += legLeft.getHp();
        newHp += legRight.getHp();
        newHp += armLeft.getHp();
        newHp += armRight.getHp();
        newHp += tail.getHp();
        maxHP = newHp;
        currentHp = maxHP;
    }

    private void composeImage() {
        image = CreatureComposer.composeImage(((BodyBodyPart) body).getConnectors(),
                head, armLeft, armRight, legLeft, legRight, tail, body);
    }


    public void attack(float dmg){
        if(currentHp - dmg < 0)
            currentHp = 0;
        else
            currentHp -= dmg;
    }

    public float getMaxHp(){
        return maxHP;
    }

    public float getCurrentHp() {
        return currentHp;
    }

    public Attack getAt1() {
        return at1;
    }
    public Attack getAt2() {
        return at2;
    }
    public Attack getAt3() {
        return at3;
    }
    public Attack getAt4() {
        return at4;
    }
    public Attack getAt5() {
        return at5;
    }
    public Attack getAt6() {
        return at6;
    }

    public AbstractBodyPart getHead() {
        return head;
    }
    public AbstractBodyPart getArmLeft() {
        return armLeft;
    }
    public AbstractBodyPart getArmRight() {
        return armRight;
    }
    public AbstractBodyPart getLegLeft() {
        return legLeft;
    }
    public AbstractBodyPart getLegRight() {
        return legRight;
    }
    public AbstractBodyPart getTail() {
        return tail;
    }
    public AbstractBodyPart getBody() {
        return body;
    }

    public SuperImage getImage() {
        composeImage();
        return image;
    }
}
