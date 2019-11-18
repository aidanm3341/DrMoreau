package data;

import combat.stats.Stat;
import data.bodyparts.ConcreteBodyPart;
import data.framework.BodyPart;
import data.framework.BodyPartLoader;
import data.framework.PartType;
import org.newdawn.slick.SlickException;
import util.Point;

import java.util.HashMap;
import java.util.Map;

public class HardCodedLoader implements BodyPartLoader {

    private Map<String, BodyPart> parts;

    public HardCodedLoader(){
        parts = new HashMap<>();
        loadDogParts();
        loadRatParts();
    }

    public void loadDogParts(){
        Map<Stat, Integer> stats = new HashMap<>();
        stats.put(Stat.MAX_HP, 10);
        parts.put("dog_head", new ConcreteBodyPart("dog_head", stats, makeBodyAttachPoint(new Point(0, 72))));

        stats = new HashMap<>();
        stats.put(Stat.MAX_HP, 10);
        parts.put("dog_leg", new ConcreteBodyPart("dog_leg", stats, makeBodyAttachPoint(new Point(40, 20))));

        stats = new HashMap<>();
        stats.put(Stat.MAX_HP, 10);
        parts.put("dog_arm", new ConcreteBodyPart("dog_arm", stats, makeBodyAttachPoint(new Point(36, 15))));

        stats = new HashMap<>();
        stats.put(Stat.MAX_HP, 10);
        parts.put("dog_tail", new ConcreteBodyPart("dog_tail", stats, makeBodyAttachPoint(new Point(79, 19))));

        stats = new HashMap<>();
        stats.put(Stat.MAX_HP, 10);
        Map<PartType, Point> points = new HashMap<>();
        points.put(PartType.HEAD, new Point(220, 38));
        points.put(PartType.RIGHT_ARM, new Point(195, 47));
        points.put(PartType.LEFT_ARM, new Point(171, 35));
        points.put(PartType.RIGHT_LEG, new Point(73, 35));
        points.put(PartType.LEFT_LEG, new Point(49, 23));
        points.put(PartType.TAIL, new Point(0, 46));
        parts.put("dog_body", new ConcreteBodyPart("dog_body", stats, points));
    }

    public void loadRatParts(){
        Map<Stat, Integer> stats = new HashMap<>();
        stats.put(Stat.MAX_HP, 10);
        parts.put("rat_head", new ConcreteBodyPart("rat_head", stats, makeBodyAttachPoint(new Point(20, 70))));

        stats = new HashMap<>();
        stats.put(Stat.MAX_HP, 10);
        parts.put("rat_leg", new ConcreteBodyPart("rat_leg", stats, makeBodyAttachPoint(new Point(36, 20))));

        stats = new HashMap<>();
        stats.put(Stat.MAX_HP, 10);
        parts.put("rat_arm", new ConcreteBodyPart("rat_arm", stats, makeBodyAttachPoint(new Point(43, 20))));

        stats = new HashMap<>();
        stats.put(Stat.MAX_HP, 10);
        parts.put("rat_tail", new ConcreteBodyPart("rat_tail", stats, makeBodyAttachPoint(new Point(85, 20))));

        stats = new HashMap<>();
        stats.put(Stat.MAX_HP, 10);
        Map<PartType, Point> points = new HashMap<>();
        points.put(PartType.HEAD, new Point(238, 98));
        points.put(PartType.RIGHT_ARM, new Point(200, 84));
        points.put(PartType.LEFT_ARM, new Point(175, 72));
        points.put(PartType.RIGHT_LEG, new Point(75, 84));
        points.put(PartType.LEFT_LEG, new Point(50, 72));
        points.put(PartType.TAIL, new Point(-10, 78));
        parts.put("rat_body", new ConcreteBodyPart("rat_body", stats, points));
    }

    private Map<PartType, Point> makeBodyAttachPoint(Point point){
        Map<PartType, Point> points = new HashMap<>();
        points.put(PartType.BODY, point);
        return points;
    }

    public Map<String, BodyPart> getBodyParts() throws SlickException {
        return parts;
    }
}
