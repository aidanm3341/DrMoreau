package main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;
import upgrade.bodyparts.AbstractBodyPart;
import upgrade.bodyparts.BodyPart;
import upgrade.bodyparts.BodyConnectors;
import upgrade.bodyparts.NullBodyPart;
import util.CreatureComposer;
import util.PositionedImage;
import util.ResourceLoader;
import util.SuperImage;

public class SidekickData {

    private Attack at1, at2, at3, at4, at5, at6;
    private AbstractBodyPart head, armLeft, armRight, legLeft, legRight, tail, body;
    private BodyConnectors connectors;
    private int hp;
    private SuperImage image;

    public SidekickData(){

    }

    public void init(GameContainer gc) {
        at1 = new Attack("Punch!", 5);
        at2 = new Attack("Kick!", 5);
        at3 = new Attack("Shoot!", 10);
        at4 = new Attack("Exterminate!!", 15);
        at5 = new Attack("Push :/", 1);
        at6 = new Attack("Handshake.", -1);

        head = new NullBodyPart();
        armLeft = new NullBodyPart();
        armRight = new NullBodyPart();
        legLeft = new NullBodyPart();
        legRight = new NullBodyPart();
        tail = new NullBodyPart();
        body = new NullBodyPart();

        image = new SuperImage();
        addBody(new BodyPart("dog_body", "body", at1, 30,
                ResourceLoader.getImage("dog_body"), null));

        Image dogLeg = ResourceLoader.getImage("dog_leg");
        addLegLeft(new BodyPart("dog_leg", "leg", at2, 5, dogLeg,
                new Point(dogLeg.getWidth()/2, 20)));

        Image dogArm = ResourceLoader.getImage("dog_arm");
        addArmLeft(new BodyPart("dog_arm", "arm", at2, 5, dogArm,
                new Point(dogArm.getWidth()/2, 15)));

        addLegRight(new BodyPart("dog_leg", "leg", at2, 5, dogLeg,
                new Point(dogLeg.getWidth()/2, 20)));

        addArmRight(new BodyPart("dog_arm", "arm", at2, 5, dogArm,
                new Point(dogArm.getWidth()/2, 15)));

        Image dogTail = ResourceLoader.getImage("dog_tail");
        addTail(new BodyPart("dog_tail", "tail", at2, 5, dogTail,
                new Point(dogTail.getWidth()-15, dogTail.getHeight()/2)));

        Image dogHead = ResourceLoader.getImage("dog_head");
        addHead(new BodyPart("dog_head", "head", at1, 10, dogHead,
                new Point(0, dogHead.getHeight() - 40)));

        //composeImage();
    }



    public void addBody(AbstractBodyPart newPart){
        body = newPart;
        connectors = new BodyConnectors(body);
        composeImage();
    }

    public void addHead(AbstractBodyPart newPart){
        head = newPart;
    }

    public void addLegLeft(AbstractBodyPart newPart){
        legLeft = newPart;
    }

    public void addLegRight(AbstractBodyPart newPart){
        legRight = newPart;
    }

    public void addArmLeft(AbstractBodyPart newPart){
        armLeft = newPart;
    }

    public void addArmRight(AbstractBodyPart newPart){
        armRight = newPart;
    }

    public void addTail(AbstractBodyPart newPart){
        tail = newPart;
    }


    private void composeImage() {
        image = CreatureComposer.composeImage(connectors, head, armLeft, armRight, legLeft, legRight, tail, body);
    }


    public void attack(int dmg){
        hp -= dmg;
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
