package data.mobs;

import data.framework.IBodyPart;
import data.framework.PartType;
import util.Point;

import java.util.Map;

public class Dog {

    public Map<String, IBodyPart> loadDogParts(){
        MobPointGroup pointGroup = new MobPointGroup(
                new Point(0, 72),
                new Point(40, 20),
                new Point(36, 15),
                new Point(79, 19),
                Map.of(
                        PartType.HEAD, new Point(220, 38),
                        PartType.RIGHT_ARM, new Point(195, 47),
                        PartType.LEFT_ARM, new Point(171, 35),
                        PartType.RIGHT_LEG, new Point(73, 35),
                        PartType.LEFT_LEG, new Point(49, 23),
                        PartType.TAIL, new Point(0, 46)
                )
        );

        AnimalTemplate template = new AnimalTemplate("dog", pointGroup);
        return template.getPartsWithAttachPoints();
    }
}
