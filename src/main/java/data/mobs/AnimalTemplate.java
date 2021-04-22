package data.mobs;

import combat.stats.Stat;
import combat.stats.Stats;
import data.bodyparts.BodyPart;
import data.framework.IBodyPart;
import data.framework.PartType;
import util.Point;

import java.util.Map;

public class AnimalTemplate {

    private final String name;
    private final MobPointGroup mobPoints;

    public AnimalTemplate(String name, MobPointGroup mobPoints) {
        this.name = name;
        this.mobPoints = mobPoints;
    }

    public Map<String, IBodyPart> getPartsWithAttachPoints(){
        Stats stats = new Stats();
        stats.put(Stat.MAX_HP, 5f);
        stats.put(Stat.CURRENT_HP, stats.get(Stat.MAX_HP));
        stats.put(Stat.ATTACK_DMG, 1f);

        return Map.of(
                name + "_head", new BodyPart(name + "_head", stats.clone(), makeBodyAttachPoint(mobPoints.headAttachPoint())),
                name + "_leg", new BodyPart(name + "_leg", stats.clone(), makeBodyAttachPoint(mobPoints.legAttachPoint())),
                name + "_arm", new BodyPart(name + "_arm", stats.clone(), makeBodyAttachPoint(mobPoints.armAttachPoint())),
                name + "_tail", new BodyPart(name + "_tail", stats.clone(), makeBodyAttachPoint(mobPoints.tailAttachPoint())),
                name + "_body", new BodyPart(name + "_body", stats.clone(), mobPoints.bodyAttachPoints())
        );
    }

    private Map<PartType, Point> makeBodyAttachPoint(Point point){
        return Map.of(PartType.BODY, point);
    }
}
