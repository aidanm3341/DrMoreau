package data;

import combat.stats.Stat;
import combat.stats.Stats;
import data.bodyparts.BodyPart;
import data.framework.IBodyPart;
import data.framework.BodyPartLoader;
import data.framework.PartType;
import org.newdawn.slick.SlickException;
import util.Point;

import java.util.HashMap;
import java.util.Map;

public class HardCodedLoader implements BodyPartLoader {

    private Map<String, IBodyPart> parts;

    public HardCodedLoader(){
        parts = new HashMap<>();
        loadDogParts();
        loadRatParts();
    }

    public void loadDogParts(){
        Stats stats = new Stats();
        stats.put(Stat.MAX_HP, 5f);
        stats.put(Stat.CURRENT_HP, stats.get(Stat.MAX_HP));
        stats.put(Stat.ATTACK_DMG, 1f);

        parts.put("dog_head", new BodyPart("dog_head", stats.clone(), makeBodyAttachPoint(new Point(0, 72))));
        parts.put("dog_leg", new BodyPart("dog_leg", stats.clone(), makeBodyAttachPoint(new Point(40, 20))));
        parts.put("dog_arm", new BodyPart("dog_arm", stats.clone(), makeBodyAttachPoint(new Point(36, 15))));
        parts.put("dog_tail", new BodyPart("dog_tail", stats.clone(), makeBodyAttachPoint(new Point(79, 19))));

        Map<PartType, Point> points = new HashMap<>();
        points.put(PartType.HEAD, new Point(220, 38));
        points.put(PartType.RIGHT_ARM, new Point(195, 47));
        points.put(PartType.LEFT_ARM, new Point(171, 35));
        points.put(PartType.RIGHT_LEG, new Point(73, 35));
        points.put(PartType.LEFT_LEG, new Point(49, 23));
        points.put(PartType.TAIL, new Point(0, 46));
        parts.put("dog_body", new BodyPart("dog_body", stats.clone(), points));
    }

    public void loadRatParts(){
        Stats stats = new Stats();
        stats.put(Stat.MAX_HP, 4f);
        stats.put(Stat.CURRENT_HP, stats.get(Stat.MAX_HP));
        stats.put(Stat.ATTACK_DMG, 1f);

        parts.put("rat_head", new BodyPart("rat_head", stats.clone(), makeBodyAttachPoint(new Point(20, 70))));
        parts.put("rat_leg", new BodyPart("rat_leg", stats.clone(), makeBodyAttachPoint(new Point(36, 20))));
        parts.put("rat_arm", new BodyPart("rat_arm", stats.clone(), makeBodyAttachPoint(new Point(43, 20))));
        parts.put("rat_tail", new BodyPart("rat_tail", stats.clone(), makeBodyAttachPoint(new Point(85, 20))));

        Map<PartType, Point> points = new HashMap<>();
        points.put(PartType.HEAD, new Point(238, 98));
        points.put(PartType.RIGHT_ARM, new Point(200, 84));
        points.put(PartType.LEFT_ARM, new Point(175, 72));
        points.put(PartType.RIGHT_LEG, new Point(75, 84));
        points.put(PartType.LEFT_LEG, new Point(50, 72));
        points.put(PartType.TAIL, new Point(-10, 78));
        parts.put("rat_body", new BodyPart("rat_body", stats.clone(), points));
    }

    private Map<PartType, Point> makeBodyAttachPoint(Point point){
        Map<PartType, Point> points = new HashMap<>();
        points.put(PartType.BODY, point);
        return points;
    }

    public Map<String, IBodyPart> getBodyParts() throws SlickException {
        return parts;
    }
}
