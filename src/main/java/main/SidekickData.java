package main;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;
import upgrade.BodyPart;
import upgrade.BodyConnectors;
import util.PositionedImage;
import util.ResourceLoader;
import util.SuperImage;

public class SidekickData {

    private Attack at1, at2, at3, at4, at5, at6;
    private BodyPart head, armLeft, armRight, legLeft, legRight, tail, body;
    private BodyConnectors connectors;
    private int hp;
    private SuperImage image;

    public SidekickData(){
        at1 = new Attack("Punch!", 5);
        at2 = new Attack("Kick!", 5);
        at3 = new Attack("Shoot!", 10);
        at4 = new Attack("Exterminate!!", 15);
        at5 = new Attack("Push :/", 1);
        at6 = new Attack("Handshake.", -1);


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

        composeImage();
    }



    public void addBody(BodyPart newPart){
        body = newPart;
        connectors = new BodyConnectors(body);
        composeImage();
    }

    public void addHead(BodyPart newPart){
        head = newPart;
        composeImage();
    }

    public void addLegLeft(BodyPart newPart){
        legLeft = newPart;
        composeImage();
    }

    public void addLegRight(BodyPart newPart){
        legRight = newPart;
        composeImage();
    }

    public void addArmLeft(BodyPart newPart){
        armLeft = newPart;
        composeImage();
    }

    public void addArmRight(BodyPart newPart){
        armRight = newPart;
        composeImage();
    }

    public void addTail(BodyPart newPart){
        tail = newPart;
        composeImage();
    }


    private void composeImage() {
        if(legLeft != null) {
            image.addImage(new PositionedImage(legLeft.getImage(),
                    connectors.getLegLeftP().getX() - legLeft.getAttachPoint().getX(),
                    connectors.getLegLeftP().getY() - legLeft.getAttachPoint().getY()));
        }
        if(armLeft != null) {
            image.addImage(new PositionedImage(armLeft.getImage(),
                    connectors.getArmLeftP().getX() - armLeft.getAttachPoint().getX(),
                    connectors.getArmLeftP().getY() - armLeft.getAttachPoint().getY()));
        }
        if(body != null) {
            // NOTE : NEEDS TO BE HERE TO BE RENDERED PROPERLY
            image.addImage(new PositionedImage(body.getImage(), 0, 0));
            //
        }
        if(legRight != null) {
            image.addImage(new PositionedImage(legRight.getImage(),
                    connectors.getLegRightP().getX() - legRight.getAttachPoint().getX(),
                    connectors.getLegRightP().getY() - legRight.getAttachPoint().getY()));
        }
        if(armRight != null) {
            image.addImage(new PositionedImage(armRight.getImage(),
                    connectors.getArmRightP().getX() - armRight.getAttachPoint().getX(),
                    connectors.getArmRightP().getY() - armRight.getAttachPoint().getY()));
        }
        if(tail != null) {
            image.addImage(new PositionedImage(tail.getImage(),
                    connectors.getTailP().getX() - tail.getAttachPoint().getX(),
                    connectors.getTailP().getY() - tail.getAttachPoint().getY()));
        }
        if(head != null) {
            image.addImage(new PositionedImage(head.getImage(),
                    connectors.getHeadP().getX() - head.getAttachPoint().getX(),
                    connectors.getHeadP().getY() - head.getAttachPoint().getY()));
        }
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

    public SuperImage getImage() {
        return image;
    }
}
