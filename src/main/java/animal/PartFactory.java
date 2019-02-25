package animal;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import util.ResourceLoader;

import java.util.HashMap;

public class PartFactory {

    public static Part getPart(String name) throws SlickException
    {
        switch(name)
        {
            case "dog_leg":
                Image dogLeg = ResourceLoader.getImage("dog_leg");
                return new Part(PartType.LEG, dogLeg, new Point(dogLeg.getWidth()/2, 20));

            case "dog_arm":
                Image dogArm = ResourceLoader.getImage("dog_arm");
                return new Part(PartType.ARM, dogArm, new Point(dogArm.getWidth()/2, 15));

            case "dog_head":
                Image dogHead = ResourceLoader.getImage("dog_head");
                return new Part(PartType.HEAD, dogHead, new Point(0, dogHead.getHeight() - 40));

            case "dog_tail":
                Image dogTail = ResourceLoader.getImage("dog_tail");
                return new Part (PartType.TAIL, dogTail, new Point(dogTail.getWidth()-15, dogTail.getHeight()/2));

            case "ostrich_head":
                Image ostrichHead = ResourceLoader.getImage("ostrich_head");
                return new Part(PartType.HEAD, ostrichHead, new Point(0, ostrichHead.getHeight() - 20));

            case "blue_leg":
                Image blueLeg = ResourceLoader.getImage("blue_leg");
                return new Part(PartType.LEG, blueLeg, new Point(blueLeg.getWidth()/2, 0));
            case "dog_body":
                Image dogBody = ResourceLoader.getImage("dog_body");
                return new Part(PartType.BODY, dogBody, null);
            default:
                throw new SlickException("Not a valid animal part.");
        }
    }
}
