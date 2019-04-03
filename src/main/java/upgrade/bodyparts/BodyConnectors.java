package upgrade.bodyparts;

import org.newdawn.slick.geom.Point;
import upgrade.bodyparts.AbstractBodyPart;

public class BodyConnectors{

    private Point headP, armRightP, armLeftP, legLeftP, legRightP, tailP;

    public BodyConnectors(Point headP, Point armRightP, Point armLeftP, Point legRightP, Point legLeftP, Point tailP)
    {
        //headP = new Point(bodyPart.getWidth()*0.9f, (bodyPart.getHeight()*0.33f));
        //armRightP = new Point(bodyPart.getWidth()*0.8f, bodyPart.getHeight()*0.4f);
        //armLeftP = new Point(bodyPart.getWidth()*0.7f, bodyPart.getHeight()*0.3f);
        //legRightP = new Point (bodyPart.getWidth()*0.3f, bodyPart.getHeight()*0.3f);
        //legLeftP = new Point (bodyPart.getWidth()*0.2f, bodyPart.getHeight()*0.2f);
        //tailP = new Point(0, bodyPart.getHeight()*0.4f);
        this.headP = headP;
        this.armRightP = armRightP;
        this.armLeftP = armLeftP;
        this.legRightP = legRightP;
        this.legLeftP = legLeftP;
        this.tailP = tailP;
    }




    public Point getHeadP() {
        return headP;
    }

    public Point getArmRightP() {
        return armRightP;
    }

    public Point getArmLeftP() {
        return armLeftP;
    }

    public Point getLegLeftP() {
        return legLeftP;
    }

    public Point getLegRightP() {
        return legRightP;
    }

    public Point getTailP() {
        return tailP;
    }
}
