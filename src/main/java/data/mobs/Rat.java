package data.mobs;

import data.framework.IBodyPart;
import data.framework.PartType;
import util.Point;

import java.util.Map;

public class Rat {

    public Map<String, IBodyPart> loadRatParts(){
        MobPointGroup pointGroup = new MobPointGroup(
                new Point(20, 70),
                new Point(36, 20),
                new Point(43, 20),
                new Point(85, 20),
                Map.of(
                        PartType.HEAD, new Point(238, 98),
                        PartType.RIGHT_ARM, new Point(200, 84),
                        PartType.LEFT_ARM, new Point(175, 72),
                        PartType.RIGHT_LEG, new Point(75, 84),
                        PartType.LEFT_LEG, new Point(50, 72),
                        PartType.TAIL, new Point(-10, 78)
                )
        );

        AnimalTemplate template = new AnimalTemplate("rat", pointGroup);
        return template.getPartsWithAttachPoints();
    }
}
