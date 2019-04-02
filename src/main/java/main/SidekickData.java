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
        initBody();
        initLegLeft();
        initArmLeft();
        // NOTE : NEEDS TO BE HERE TO BE RENDERED PROPERLY, AS OPPOSED TO IN THE initBody METHOD.
        image.addImage(new PositionedImage(body.getImage(),0, 0));
        //
        initLegRight();
        initArmRight();
        initTail();
        initHead();
    }

    private void initBody() {
        body = new BodyPart("dog_body", "body", at1, 30, ResourceLoader.getImage("dog_body"), null);
        connectors = new BodyConnectors(body);
    }

    private void initHead() {
        Image dogHead = ResourceLoader.getImage("dog_head");
        head = new BodyPart("dog_head", "head", at1, 10, dogHead,
                new Point(0, dogHead.getHeight() - 40));

        image.addImage(new PositionedImage(head.getImage(),
                connectors.getHeadP().getX() - head.getAttachPoint().getX(),
                connectors.getHeadP().getY() - head.getAttachPoint().getY()));
    }

    private void initLegLeft(){
        Image dogLeg = ResourceLoader.getImage("dog_leg");
        legLeft = new BodyPart("dog_leg", "leg", at2, 5, dogLeg,
                new Point(dogLeg.getWidth()/2, 20));

        image.addImage(new PositionedImage(legLeft.getImage(),
                connectors.getLegLeftP().getX() - legLeft.getAttachPoint().getX(),
                connectors.getLegLeftP().getY() - legLeft.getAttachPoint().getY()));
    }

    private void initLegRight(){
        Image dogLeg = ResourceLoader.getImage("dog_leg");
        legRight = new BodyPart("dog_leg", "leg", at2, 5, dogLeg,
                new Point(dogLeg.getWidth()/2, 20));

        image.addImage(new PositionedImage(legRight.getImage(),
                connectors.getLegRightP().getX() - legRight.getAttachPoint().getX(),
                connectors.getLegRightP().getY() - legRight.getAttachPoint().getY()));
    }

    private void initArmLeft(){
        Image dogArm = ResourceLoader.getImage("dog_arm");
        armLeft = new BodyPart("dog_arm", "arm", at2, 5, dogArm,
                new Point(dogArm.getWidth()/2, 15));

        image.addImage(new PositionedImage(armLeft.getImage(),
                connectors.getArmLeftP().getX() - armLeft.getAttachPoint().getX(),
                connectors.getArmLeftP().getY() - armLeft.getAttachPoint().getY()));
    }

    private void initArmRight(){
        Image dogArm = ResourceLoader.getImage("dog_arm");
        armRight = new BodyPart("dog_arm", "arm", at2, 5, dogArm,
                new Point(dogArm.getWidth()/2, 15));

        image.addImage(new PositionedImage(armRight.getImage(),
                connectors.getArmRightP().getX() - armRight.getAttachPoint().getX(),
                connectors.getArmRightP().getY() - armRight.getAttachPoint().getY()));
    }

    private void initTail(){
        Image dogTail = ResourceLoader.getImage("dog_tail");
        tail = new BodyPart("dog_tail", "tail", at2, 5, dogTail,
                new Point(dogTail.getWidth()-15, dogTail.getHeight()/2));

        image.addImage(new PositionedImage(tail.getImage(),
                connectors.getTailP().getX() - tail.getAttachPoint().getX(),
                connectors.getTailP().getY() - tail.getAttachPoint().getY()));
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
