package upgrade.bodyparts;

import org.newdawn.slick.SlickException;

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
}
