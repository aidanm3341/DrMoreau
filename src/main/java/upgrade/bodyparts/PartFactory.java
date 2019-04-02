package upgrade.bodyparts;

import main.Attack;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import upgrade.bodyparts.BodyPart;
import util.ResourceLoader;

public class PartFactory {

    public static BodyPart getPart(String name) throws SlickException
    {
        Attack at1 = new Attack("Punch!", 5);
        switch(name)
        {
            case "dog_leg":
                Image dogLeg = ResourceLoader.getImage("dog_leg");
                return new BodyPart("dog_leg", "leg", at1, 5, dogLeg, new Point(dogLeg.getWidth()/2, 20));

            case "dog_arm":
                Image dogArm = ResourceLoader.getImage("dog_arm");
                return new BodyPart("dog_arm", "arm", at1, 5, dogArm, new Point(dogArm.getWidth()/2, 15));

            case "dog_head":
                Image dogHead = ResourceLoader.getImage("dog_head");
                return new BodyPart("dog_head", "head", at1, 5, dogHead, new Point(0, dogHead.getHeight() - 40));

            case "dog_tail":
                Image dogTail = ResourceLoader.getImage("dog_tail");
                return new BodyPart("dog_tail", "tail", at1, 5, dogTail, new Point (dogTail.getWidth()-15, dogTail.getHeight()/2));

            case "ostrich_head":
                Image ostrichHead = ResourceLoader.getImage("ostrich_head");
                return new BodyPart("ostrich_head", "head", at1, 5, ostrichHead, new Point(0, ostrichHead.getHeight() - 20));

            case "blue_leg":
                Image blueLeg = ResourceLoader.getImage("blue_leg");
                return new BodyPart("blue_leg", "leg", at1, 5, blueLeg, new Point(blueLeg.getWidth()/2, 0));
            case "dog_body":
                Image dogBody = ResourceLoader.getImage("dog_body");
                return new BodyPart("dog_body", "body", at1, 5, dogBody, null);
            default:
                throw new SlickException("Not a valid animal part.");
        }
    }
}
