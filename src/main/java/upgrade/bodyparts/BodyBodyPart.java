package upgrade.bodyparts;

import main.Attack;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;

public class BodyBodyPart extends BodyPart{

    public BodyConnectors connectors;

    public BodyBodyPart(String name, String type, Attack attack, int hp, Image image, Point attachPoint,
                        BodyConnectors connectors) throws SlickException {
        super(name, type, attack, hp, image, attachPoint);
        this.connectors = connectors;
    }

    public BodyConnectors getConnectors() {
        return connectors;
    }
}
