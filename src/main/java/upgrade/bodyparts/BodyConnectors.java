package upgrade.bodyparts;

import org.newdawn.slick.geom.Point;

public class BodyConnectors{

    private Point headP, armRightP, armLeftP, legLeftP, legRightP, tailP;

    public BodyConnectors(Point headP, Point armRightP, Point armLeftP, Point legRightP, Point legLeftP, Point tailP)
    {
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
