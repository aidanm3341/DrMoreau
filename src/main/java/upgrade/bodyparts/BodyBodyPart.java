package upgrade.bodyparts;

import combat.Attack;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;

public class BodyBodyPart extends BodyPart{

    public BodyConnectors connectors;

    public BodyBodyPart(String name, String type, int hp,
                        BodyConnectors connectors, int level) throws SlickException {
        super(name, type, null, hp, null, level);
        this.connectors = connectors;
    }

    public BodyConnectors getConnectors() {
        return connectors;
    }

    public AbstractBodyPart clone(int level) throws SlickException
    {
        return new BodyBodyPart(getName(), getType(), getHp(), connectors, level);
    }
}
