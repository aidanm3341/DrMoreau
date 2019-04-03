package util;

import upgrade.bodyparts.AbstractBodyPart;
import upgrade.bodyparts.BodyConnectors;

public class CreatureComposer {

    //private AbstractBodyPart head, armLeft, armRight, legLeft, legRight, tail, body;
    //private BodyConnectors connectors;

    public static SuperImage composeImage(BodyConnectors connectors, AbstractBodyPart head, AbstractBodyPart armLeft,
                                    AbstractBodyPart armRight, AbstractBodyPart legLeft,
                                    AbstractBodyPart legRight, AbstractBodyPart tail, AbstractBodyPart body) {
        SuperImage image = new SuperImage();

        image.addImage(new PositionedImage(legLeft.getImage(),
                connectors.getLegLeftP().getX() - legLeft.getAttachPoint().getX(),
                connectors.getLegLeftP().getY() - legLeft.getAttachPoint().getY()));

        image.addImage(new PositionedImage(armLeft.getImage(),
                connectors.getArmLeftP().getX() - armLeft.getAttachPoint().getX(),
                connectors.getArmLeftP().getY() - armLeft.getAttachPoint().getY()));

        // NOTE : NEEDS TO BE HERE TO BE RENDERED PROPERLY
        image.addImage(new PositionedImage(body.getImage(), 0, 0));
        //

        image.addImage(new PositionedImage(legRight.getImage(),
                connectors.getLegRightP().getX() - legRight.getAttachPoint().getX(),
                connectors.getLegRightP().getY() - legRight.getAttachPoint().getY()));

        image.addImage(new PositionedImage(armRight.getImage(),
                connectors.getArmRightP().getX() - armRight.getAttachPoint().getX(),
                connectors.getArmRightP().getY() - armRight.getAttachPoint().getY()));

        image.addImage(new PositionedImage(tail.getImage(),
                connectors.getTailP().getX() - tail.getAttachPoint().getX(),
                connectors.getTailP().getY() - tail.getAttachPoint().getY()));

        image.addImage(new PositionedImage(head.getImage(),
                connectors.getHeadP().getX() - head.getAttachPoint().getX(),
                connectors.getHeadP().getY() - head.getAttachPoint().getY()));

        return image;
    }

}
