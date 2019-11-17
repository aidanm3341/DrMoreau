package upgrade.bodyparts;

import data.framework.PartType;
import util.Point;

import java.util.HashMap;
import java.util.Map;

public class BodyConcreteBodyPart extends ConcreteBodyPart {

    public BodyConnectors connectors;

    public BodyConcreteBodyPart(String name, int hp,
                                BodyConnectors connectors, int level){
        super(name, null, hp, null, level);
        this.connectors = connectors;
    }

    public Map<PartType, Point> getAttachPoints() {
        Map<PartType, Point> map = new HashMap<>();
        map.put(PartType.LEFT_ARM, connectors.getArmLeftP());
        map.put(PartType.RIGHT_ARM, connectors.getArmRightP());
        map.put(PartType.HEAD, connectors.getHeadP());
        map.put(PartType.LEFT_LEG, connectors.getLegLeftP());
        map.put(PartType.RIGHT_LEG, connectors.getLegRightP());
        map.put(PartType.TAIL, connectors.getTailP());
        return map;
    }

    public BodyConnectors getConnectors() {
        return connectors;
    }

    public BodyConcreteBodyPart clone() {
        return new BodyConcreteBodyPart(name, hp, connectors, level);
    }
}
