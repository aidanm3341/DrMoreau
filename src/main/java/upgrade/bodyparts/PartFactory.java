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
                        new Point(bunnyHead.getWidth() * 0.4f, bunnyHead.getHeight() - 40));
            case "bunny_leg":
                Image bunnyLeg = ResourceLoader.getImage("bunny_leg");
                return new BodyPart("bunny_leg", "leg", at1, 5, bunnyLeg,
                        new Point(bunnyLeg.getWidth()/2, 45));
            case "bunny_arm":
                Image bunnyArm = ResourceLoader.getImage("bunny_arm").getScaledCopy(0.8f);
                return new BodyPart("bunny_arm", "arm", at1, 5, bunnyArm,
                        new Point(bunnyArm.getWidth()*0.4f, 20));
            case "bunny_tail":
                Image bunnyTail = ResourceLoader.getImage("bunny_tail");
                return new BodyPart("bunny_tail", "tail", at1, 5, bunnyTail,
                        new Point (bunnyTail.getWidth()* 0.55f, bunnyTail.getHeight()/2));
            case "bunny_body":
                Image bunnyBody = ResourceLoader.getImage("bunny_body");
                connectors = new BodyConnectors(
                        new Point(bunnyBody.getWidth()*0.8f, (bunnyBody.getHeight()*0.3f)),
                        new Point(bunnyBody.getWidth()*0.67f, bunnyBody.getHeight()*0.6f),
                        new Point(bunnyBody.getWidth()*0.57f, bunnyBody.getHeight()*0.55f),
                        new Point (bunnyBody.getWidth()*0.25f, bunnyBody.getHeight()*0.66f),
                        new Point (bunnyBody.getWidth()*0.2f, bunnyBody.getHeight()*0.6f),
                        new Point(0, bunnyBody.getHeight()*0.66f));
                return new BodyBodyPart("bunny_body", "body", at1, 5, bunnyBody,null, connectors);

            case "penguin_head":
                Image penguinHead = ResourceLoader.getImage("penguin_head");
                return new BodyPart("penguin_head", "head", at1, 5, penguinHead,
                        new Point(penguinHead.getWidth() * 0.4f, penguinHead.getHeight() - 40));
            case "penguin_leg":
                Image penguinLeg = ResourceLoader.getImage("penguin_leg");
                return new BodyPart("penguin_leg", "leg", at1, 5, penguinLeg,
                        new Point(penguinLeg.getWidth()/2, 45));
            case "penguin_arm":
                Image penguinArm = ResourceLoader.getImage("penguin_arm").getScaledCopy(0.8f);
                return new BodyPart("penguin_arm", "arm", at1, 5, penguinArm,
                        new Point(penguinArm.getWidth()*0.4f, 20));
            case "penguin_tail":
                Image penguinTail = ResourceLoader.getImage("penguin_tail");
                return new BodyPart("penguin_tail", "tail", at1, 5, penguinTail,
                        new Point (penguinTail.getWidth()* 0.55f, penguinTail.getHeight()/2));
            case "penguin_body":
                Image penguinBody = ResourceLoader.getImage("penguin_body");
                connectors = new BodyConnectors(
                        new Point(penguinBody.getWidth()*0.8f, (penguinBody.getHeight()*0.3f)),
                        new Point(penguinBody.getWidth()*0.67f, penguinBody.getHeight()*0.6f),
                        new Point(penguinBody.getWidth()*0.57f, penguinBody.getHeight()*0.55f),
                        new Point (penguinBody.getWidth()*0.25f, penguinBody.getHeight()*0.66f),
                        new Point (penguinBody.getWidth()*0.2f, penguinBody.getHeight()*0.6f),
                        new Point(0, penguinBody.getHeight()*0.66f));
                return new BodyBodyPart("penguin_body", "body", at1, 5, penguinBody,null, connectors);

            case "lion_head":
                Image lionHead = ResourceLoader.getImage("lion_head");
                return new BodyPart("lion_head", "head", at1, 5, lionHead,
                        new Point(lionHead.getWidth() * 0.4f, lionHead.getHeight() - 40));
            case "lion_leg":
                Image lionLeg = ResourceLoader.getImage("lion_leg");
                return new BodyPart("lion_leg", "leg", at1, 5, lionLeg,
                        new Point(lionLeg.getWidth()/2, 45));
            case "lion_arm":
                Image lionArm = ResourceLoader.getImage("lion_arm").getScaledCopy(0.8f);
                return new BodyPart("lion_arm", "arm", at1, 5, lionArm,
                        new Point(lionArm.getWidth()*0.4f, 20));

            case "lion_body":
                Image lionBody = ResourceLoader.getImage("lion_body");
                connectors = new BodyConnectors(
                        new Point(lionBody.getWidth()*0.8f, (lionBody.getHeight()*0.3f)),
                        new Point(lionBody.getWidth()*0.67f, lionBody.getHeight()*0.6f),
                        new Point(lionBody.getWidth()*0.57f, lionBody.getHeight()*0.55f),
                        new Point (lionBody.getWidth()*0.25f, lionBody.getHeight()*0.66f),
                        new Point (lionBody.getWidth()*0.2f, lionBody.getHeight()*0.6f),
                        new Point(0, lionBody.getHeight()*0.66f));
                return new BodyBodyPart("lion_body", "body", at1, 5, lionBody,null, connectors);

            default:
                throw new SlickException("Not a valid animal part.");
        }
    }
}
