package upgrade.bodyparts;

import org.newdawn.slick.SlickException;

public class BodyConcreteBodyPart extends ConcreteBodyPart {

    public BodyConnectors connectors;

    public BodyConcreteBodyPart(String name, String type, int hp,
                                BodyConnectors connectors, int level) throws SlickException {
        super(name, type, null, hp, null, level);
        this.connectors = connectors;
    }

    public BodyConnectors getConnectors() {
        return connectors;
    }
}
