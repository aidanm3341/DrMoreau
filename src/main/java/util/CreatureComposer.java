package util;

import data.framework.BodyPart;
import upgrade.bodyparts.BodyConnectors;

public class CreatureComposer {

    //private AbstractBodyPart head, armLeft, armRight, legLeft, legRight, tail, body;
    //private BodyConnectors connectors;

    public static SuperImage composeImage(BodyConnectors connectors, BodyPart head, BodyPart armLeft,
                                          BodyPart armRight, BodyPart legLeft,
                                          BodyPart legRight, BodyPart tail, BodyPart body) {
        SuperImage image = new SuperImage();

        image.addImage(new PositionedImage(legLeft.getImage(),
                connectors.getLegLeftP().x - legLeft.getAttachPoint().x,
                connectors.getLegLeftP().y - legLeft.getAttachPoint().y));

        image.addImage(new PositionedImage(armLeft.getImage(),
                connectors.getArmLeftP().x - armLeft.getAttachPoint().x,
                connectors.getArmLeftP().y - armLeft.getAttachPoint().y));

        // NOTE : NEEDS TO BE HERE TO BE RENDERED PROPERLY
        image.addImage(new PositionedImage(body.getImage(), 0, 0));
        //

        image.addImage(new PositionedImage(legRight.getImage(),
                connectors.getLegRightP().x - legRight.getAttachPoint().x,
                connectors.getLegRightP().y - legRight.getAttachPoint().y));

        image.addImage(new PositionedImage(armRight.getImage(),
                connectors.getArmRightP().x - armRight.getAttachPoint().x,
                connectors.getArmRightP().y - armRight.getAttachPoint().y));

        image.addImage(new PositionedImage(tail.getImage(),
                connectors.getTailP().x - tail.getAttachPoint().x,
                connectors.getTailP().y - tail.getAttachPoint().y));

        image.addImage(new PositionedImage(head.getImage(),
                connectors.getHeadP().x - head.getAttachPoint().x,
                connectors.getHeadP().y - head.getAttachPoint().y));

        return image;
    }

}
