package animal;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;
import util.ResourceLoader;

import java.util.HashMap;

public class PartFactory {

    private static HashMap<String, Part> parts;

    public static void createParts()
    {
        parts = new HashMap<>();

        Image dogLeg = ResourceLoader.getImage("dog_leg");
        parts.put("dog_leg", new Part(PartType.LEG, dogLeg, new Point(dogLeg.getWidth()/2, 20)));
        parts.put("dog_leg2", new Part(PartType.LEG2, dogLeg, new Point(dogLeg.getWidth()/2, 20)));

        Image dogArm = ResourceLoader.getImage("dog_arm");
        parts.put("dog_arm", new Part(PartType.ARM, dogArm, new Point(dogArm.getWidth()/2, 15)));
        parts.put("dog_arm2", new Part(PartType.ARM2, dogArm, new Point(dogArm.getWidth()/2, 15)));

        Image dogHead = ResourceLoader.getImage("dog_head");
        parts.put("dog_head", new Part(PartType.HEAD, dogHead, new Point(0, dogHead.getHeight() - 40)));

        Image dogTail = ResourceLoader.getImage("dog_tail");
        parts.put("dog_tail", new Part (PartType.TAIL, dogTail, new Point(dogTail.getWidth()-15, dogTail.getHeight()/2)));

        Image ostrichHead = ResourceLoader.getImage("ostrich_head");
        parts.put("ostrich_head", new Part(PartType.HEAD, ostrichHead, new Point(0, ostrichHead.getHeight() - 20)));

        Image blueLeg = ResourceLoader.getImage("blue_leg");
        parts.put("blue_leg", new Part(PartType.LEG, blueLeg, new Point(blueLeg.getWidth()/2, 0)));

    }

    public static Part getPart(String name)
    {
        return parts.get(name);
    }
}
