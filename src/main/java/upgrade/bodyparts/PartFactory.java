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
                return new BodyPart("dog_leg", "leg", at1, 5, dogLeg,
                        new Point(dogLeg.getWidth()/2, 20));
            case "dog_arm":
                Image dogArm = ResourceLoader.getImage("dog_arm");
                return new BodyPart("dog_arm", "arm", at1, 5, dogArm,
                        new Point(dogArm.getWidth()/2, 15));
            case "dog_head":
                Image dogHead = ResourceLoader.getImage("dog_head");
                return new BodyPart("dog_head", "head", at1, 5, dogHead,
                        new Point(0, dogHead.getHeight() - 40));
            case "dog_tail":
                Image dogTail = ResourceLoader.getImage("dog_tail");
                return new BodyPart("dog_tail", "tail", at1, 5, dogTail,
                        new Point (dogTail.getWidth()-15, dogTail.getHeight()/2));
            case "dog_body":
                 Image dogBody = ResourceLoader.getImage("dog_body");
                 BodyConnectors connectors = new BodyConnectors(new Point(dogBody.getWidth()*0.9f, (dogBody.getHeight()*0.33f)),
                        new Point(dogBody.getWidth()*0.8f, dogBody.getHeight()*0.4f),
                        new Point(dogBody.getWidth()*0.7f, dogBody.getHeight()*0.3f),
                        new Point (dogBody.getWidth()*0.3f, dogBody.getHeight()*0.3f),
                        new Point (dogBody.getWidth()*0.2f, dogBody.getHeight()*0.2f),
                        new Point(0, dogBody.getHeight()*0.4f));
                 return new BodyBodyPart("dog_body", "body", at1, 5, dogBody, null, connectors);

            case "ostrich_head":
                Image ostrichHead = ResourceLoader.getImage("ostrich_head");
                return new BodyPart("ostrich_head", "head", at1, 5, ostrichHead,
                        new Point(0, ostrichHead.getHeight() - 20));

            case "rat_leg":
                Image ratLeg = ResourceLoader.getImage("rat_leg");
                return new BodyPart("rat_leg", "leg", at1, 5, ratLeg,
                        new Point(ratLeg.getWidth()/2, 20));
            case "rat_arm":
                Image ratArm = ResourceLoader.getImage("rat_arm").getScaledCopy(0.8f);
                return new BodyPart("rat_arm", "arm", at1, 5, ratArm,
                        new Point(ratArm.getWidth()/1.66f, 20));
            case "rat_head":
                Image ratHead = ResourceLoader.getImage("rat_head");
                return new BodyPart("rat_head", "head", at1, 5, ratHead,
                        new Point(20, ratHead.getHeight() - 40));
            case "rat_tail":
                Image ratTail = ResourceLoader.getImage("rat_tail");
                return new BodyPart("rat_tail", "tail", at1, 5, ratTail,
                        new Point (ratTail.getWidth()-15, ratTail.getHeight()/2));
            case "rat_body":
                Image ratBody = ResourceLoader.getImage("rat_body");
                connectors = new BodyConnectors(
                        new Point(ratBody.getWidth()*0.95f, (ratBody.getHeight()*0.8f)),
                        new Point(ratBody.getWidth()*0.8f, ratBody.getHeight()*0.7f),
                        new Point(ratBody.getWidth()*0.7f, ratBody.getHeight()*0.6f),
                        new Point (ratBody.getWidth()*0.3f, ratBody.getHeight()*0.7f),
                        new Point (ratBody.getWidth()*0.2f, ratBody.getHeight()*0.6f),
                        new Point(-10, ratBody.getHeight()*0.65f));
                return new BodyBodyPart("rat_body", "body", at1, 5, ratBody,null, connectors);

            case "bunny_head":
                Image bunnyHead = ResourceLoader.getImage("bunny_head");
                return new BodyPart("bunny_head", "head", at1, 5, bunnyHead,
                        new Point(bunnyHead.getWidth() * 1.66f, bunnyHead.getHeight() - 50));
            case "bunny_leg":
                Image bunnyLeg = ResourceLoader.getImage("bunny_leg");
                return new BodyPart("bunny_leg", "leg", at1, 5, bunnyLeg,
                        new Point(bunnyLeg.getWidth()/2, 20));
            case "bunny_arm":
                Image bunnyArm = ResourceLoader.getImage("bunny_arm").getScaledCopy(0.8f);
                return new BodyPart("bunny_arm", "arm", at1, 5, bunnyArm,
                        new Point(bunnyArm.getWidth()/1.66f, 20));
            case "bunny_tail":
                Image bunnyTail = ResourceLoader.getImage("bunny_tail");
                return new BodyPart("bunny_tail", "tail", at1, 5, bunnyTail,
                        new Point (bunnyTail.getWidth()-15, bunnyTail.getHeight()/2));
            case "bunny_body":
                Image bunnyBody = ResourceLoader.getImage("bunny_body");
                connectors = new BodyConnectors(
                        new Point(bunnyBody.getWidth()*0.95f, (bunnyBody.getHeight()*0.8f)),
                        new Point(bunnyBody.getWidth()*0.8f, bunnyBody.getHeight()*0.7f),
                        new Point(bunnyBody.getWidth()*0.7f, bunnyBody.getHeight()*0.6f),
                        new Point (bunnyBody.getWidth()*0.3f, bunnyBody.getHeight()*0.7f),
                        new Point (bunnyBody.getWidth()*0.2f, bunnyBody.getHeight()*0.6f),
                        new Point(-10, bunnyBody.getHeight()*0.65f));
                return new BodyBodyPart("bunny_body", "body", at1, 5, bunnyBody,null, connectors);

            default:
                throw new SlickException("Not a valid animal part.");
        }
    }
}
