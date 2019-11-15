package upgrade.bodyparts;

import org.newdawn.slick.geom.Point;

public class Connection {

    private PartType connectsTo;
    private Point attachPoint;

    public Connection(PartType connectsTo, Point attachPoint){
        this.connectsTo = connectsTo;
        this.attachPoint = attachPoint;
    }

    public PartType getConnectsTo() {
        return connectsTo;
    }

    public Point getAttachPoint() {
        return attachPoint;
    }
}
