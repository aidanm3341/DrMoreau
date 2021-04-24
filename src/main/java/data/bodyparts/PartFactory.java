package data.bodyparts;

import data.HardCodedLoader;
import data.framework.IBodyPart;
import data.framework.BodyPartLoader;
import org.newdawn.slick.SlickException;

import java.util.Map;

public class PartFactory {

    private static Map<String, IBodyPart> parts;
    private static BodyPartLoader loader;

    public static IBodyPart getPart(String name, int level) throws SlickException
    {
        if(loader == null)
            loader = new HardCodedLoader();
        if(parts == null)
            parts = loader.getBodyParts();

        return parts.get(name).clone();

        //Attack atk;
/*
        switch(name)
        {
            case "dog_leg":
                return parts.get("dog_leg");
//                atk = new Attack("Kick", 1,1);
//                BodyPart part = new BodyPart("dog_leg", "leg", atk, level/2+1,
//                        new Point(40, 20));
//                return part;
            case "dog_arm":
                return parts.get("dog_arm");
//                atk = new Attack("Scratch", 1,1);
//                return new BodyPart("dog_arm", "arm", atk, level/2+1,
//                        new Point(36, 15));
            case "dog_head":
                return parts.get("dog_head");
//                atk = new Attack("Rabid Bite", 1,0);
//                return new BodyPart("dog_head", "head", atk, level*10,
//                        new Point(0, 72));
            case "dog_tail":
                return parts.get("dog_tail");
//                atk = new Attack("Tail Whip", 1,0);
//                return new BodyPart("dog_tail", "tail", atk, level/3,
//                        new Point (79, 19));
            case "dog_body":
                return parts.get("dog_body");
//                Image dogBody = ResourceLoader.getImage("dog_body");
//                BodyConnectors connectors = new BodyConnectors(new Point(dogBody.getWidth()*0.9f, (dogBody.getHeight()*0.33f)),
//                        new Point(dogBody.getWidth()*0.8f, dogBody.getHeight()*0.4f),
//                        new Point(dogBody.getWidth()*0.7f, dogBody.getHeight()*0.3f),
//                        new Point (dogBody.getWidth()*0.3f, dogBody.getHeight()*0.3f),
//                        new Point (dogBody.getWidth()*0.2f, dogBody.getHeight()*0.2f),
//                        new Point(0, dogBody.getHeight()*0.4f));
//                return new BodyBodyPart("dog_body", "body", null, level/2+5, null, connectors);

            case "rat_leg":
                atk = new Attack("Kick", 2, 1);
                return new BodyPart("rat_leg", "leg", atk, level/2,
                        new Point(36, 20));
            case "rat_arm":
                atk = new Attack("Scratch", 3, -2);
                return new BodyPart("rat_arm", "arm", atk, level/2,
                        new Point(43, 20));
            case "rat_head":
                atk = new Attack("Nibble", 1, 1);
                return new BodyPart("rat_head", "head", atk, level/2+1,
                        new Point(20, 70));
            case "rat_tail":
                atk = new Attack("Whip", 3, 10);
                return new BodyPart("rat_tail", "tail", atk, level/2,
                        new Point (85, 20));
            case "rat_body":
                Image ratBody = ResourceLoader.getImage("rat_body");
                BodyConnectors connectors = new BodyConnectors(
                        new Point(ratBody.getWidth()*0.95f, (ratBody.getHeight()*0.8f)),
                        new Point(ratBody.getWidth()*0.8f, ratBody.getHeight()*0.7f),
                        new Point(ratBody.getWidth()*0.7f, ratBody.getHeight()*0.6f),
                        new Point (ratBody.getWidth()*0.3f, ratBody.getHeight()*0.7f),
                        new Point (ratBody.getWidth()*0.2f, ratBody.getHeight()*0.6f),
                        new Point(-10, ratBody.getHeight()*0.65f));
                return new BodyBodyPart("rat_body", "body", level+3, connectors);


                /*
            case "bunny_head":
                Image bunnyHead = ResourceLoader.getImage("bunny_head");
                atk = new Attack("Chew", level+1);
                return new BodyPart("bunny_head", "head", atk, level/2, bunnyHead,
                        new Point(bunnyHead.getWidth() * 0.4f, bunnyHead.getHeight() - 40));
            case "bunny_leg":
                Image bunnyLeg = ResourceLoader.getImage("bunny_leg");
                atk = new Attack("Hop", (3*level + 1)/2);
                return new BodyPart("bunny_leg", "leg", atk, level, bunnyLeg,
                        new Point(bunnyLeg.getWidth()/2, 45));
            case "bunny_arm":
                Image bunnyArm = ResourceLoader.getImage("bunny_arm").getScaledCopy(0.8f);
                atk = new Attack("Paw", level-1);
                return new BodyPart("bunny_arm", "arm", atk, level/2-1, bunnyArm,
                        new Point(bunnyArm.getWidth()*0.4f, 20));
            case "bunny_tail":
                Image bunnyTail = ResourceLoader.getImage("bunny_tail");
                atk = new Attack("Look Cute", 0);
                return new BodyPart("bunny_tail", "tail", atk, level/2, bunnyTail,
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
                return new BodyBodyPart("bunny_body", "body", null, level, bunnyBody,null, connectors);

            case "penguin_head":
                Image penguinHead = ResourceLoader.getImage("penguin_head").getScaledCopy(0.5f);
                atk = new Attack("Peck", 4);
                return new BodyPart("penguin_head", "head", atk, level/2, penguinHead,
                        new Point(penguinHead.getWidth() * 0.75f, penguinHead.getHeight()-130));
            case "penguin_leg":
                Image penguinLeg = ResourceLoader.getImage("penguin_leg").getScaledCopy(0.5f);
                atk = new Attack("Fan", 1);
                return new BodyPart("penguin_leg", "leg", atk, level/2, penguinLeg,
                        new Point(penguinLeg.getWidth()/2, 200));
            case "penguin_arm":
                Image penguinArm = ResourceLoader.getImage("penguin_arm").getScaledCopy(0.5f);
                atk = new Attack("Flap", 3);
                return new BodyPart("penguin_arm", "arm", atk, level/2, penguinArm,
                        new Point(penguinArm.getWidth()*0.75f, 200));
            case "penguin_tail":
                Image penguinTail = ResourceLoader.getImage("penguin_tail").getScaledCopy(0.5f);
                atk = new Attack("Wag", 1);
                return new BodyPart("penguin_tail", "tail", atk, level/2, penguinTail,
                        new Point (penguinTail.getWidth()* 0.1f, penguinTail.getHeight()*0.9f));
            case "penguin_body":
                Image penguinBody = ResourceLoader.getImage("penguin_body").getScaledCopy(0.5f);
                connectors = new BodyConnectors(
                        new Point(penguinBody.getWidth()*1.3f, (penguinBody.getHeight()*0.6f)),
                        new Point(penguinBody.getWidth()*0.74f, penguinBody.getHeight()*0.45f),
                        new Point(penguinBody.getWidth()*0.78f, penguinBody.getHeight()*0.55f),
                        new Point (penguinBody.getWidth()*0.24f, penguinBody.getHeight()*0.5f),
                        new Point (penguinBody.getWidth()*0.29f, penguinBody.getHeight()*0.52f),
                        new Point(-70, penguinBody.getHeight()*0.91f));
                return new BodyBodyPart("penguin_body", "body", null, level+4, penguinBody,null, connectors);

            case "lion_head":
                Image lionHead = ResourceLoader.getImage("lion_head");
                atk = new Attack("Roar", (2*level+5)/2);
                return new BodyPart("lion_head", "head", atk, level+2, lionHead,
                        new Point(lionHead.getWidth() * 0.4f, lionHead.getHeight() - 40));
            case "lion_leg":
                Image lionLeg = ResourceLoader.getImage("lion_leg");
                atk = new Attack("Pounce", level+5);
                return new BodyPart("lion_leg", "leg", atk, level/2, lionLeg,
                        new Point(lionLeg.getWidth()/2, 45));
            case "lion_arm":
                Image lionArm = ResourceLoader.getImage("lion_arm").getScaledCopy(0.8f);
                atk = new Attack("Maul", (4*level-1)/3);
                return new BodyPart("lion_arm", "arm", atk, level/2, lionArm,
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
                return new BodyBodyPart("lion_body", "body", null, level+2, lionBody,null, connectors);

            case "elephant_head":
                Image elephantHead = ResourceLoader.getImage("elephant_head");
                atk = new Attack("Charge", 3);
                return new BodyPart("elephant_head", "head", atk, 2*level+2, elephantHead,
                        new Point(elephantHead.getWidth() * 0.2f, elephantHead.getHeight() - 100));
            case "elephant_leg":
                Image elephantLeg = ResourceLoader.getImage("elephant_leg");
                atk = new Attack("Kick", 2);
                return new BodyPart("elephant_leg", "leg", atk, 2*level+3, elephantLeg,
                        new Point(elephantLeg.getWidth()/2, 45));
            case "elephant_arm":
                Image elephantArm = ResourceLoader.getImage("elephant_arm").getScaledCopy(0.8f);
                atk = new Attack("Trample", 5);
                return new BodyPart("elephant_arm", "arm", atk, 2*level, elephantArm,
                        new Point(elephantArm.getWidth()*0.4f, 20));
            case "elephant_tail":
                Image elephantTail = ResourceLoader.getImage("elephant_tail");
                atk = new Attack("Shake", 3);
                return new BodyPart("elephant_tail", "tail", atk, level+5, elephantTail,
                        new Point (elephantTail.getWidth() - 15 , elephantTail.getHeight()/2 + 10));
            case "elephant_body":
                Image elephantBody = ResourceLoader.getImage("elephant_body");
                connectors = new BodyConnectors(
                        new Point(elephantBody.getWidth()*0.8f, (elephantBody.getHeight()*0.3f)),
                        new Point(elephantBody.getWidth()*0.67f, elephantBody.getHeight()*0.6f),
                        new Point(elephantBody.getWidth()*0.57f, elephantBody.getHeight()*0.55f),
                        new Point (elephantBody.getWidth()*0.25f, elephantBody.getHeight()*0.66f),
                        new Point (elephantBody.getWidth()*0.2f, elephantBody.getHeight()*0.6f),
                        new Point(0, elephantBody.getHeight()*0.66f));
                return new BodyBodyPart("elephant_body", "body", null, 3*level+5, elephantBody,null, connectors);

            case "beaver_head":
                Image beaverHead = ResourceLoader.getImage("beaver_head");
                atk = new Attack("Chew", 4);
                return new BodyPart("beaver_head", "head", atk, level, beaverHead,
                        new Point(beaverHead.getWidth() * 0.2f, beaverHead.getHeight() * 0.8f - 30));
            case "beaver_leg":
                Image beaverLeg = ResourceLoader.getImage("beaver_leg");
                atk = new Attack("Waddle", 1);
                return new BodyPart("beaver_leg", "leg", atk, level/2, beaverLeg,
                        new Point(beaverLeg.getWidth()* 0.2f/2, 10));
            case "beaver_arm":
                Image beaverArm = ResourceLoader.getImage("beaver_arm").getScaledCopy(0.8f);
                atk = new Attack("Paw", 1);
                return new BodyPart("beaver_arm", "arm", atk, level/2, beaverArm,
                        new Point(beaverArm.getWidth()/2f, 10));
            case "beaver_tail":
                Image beaverTail = ResourceLoader.getImage("beaver_tail");
                atk = new Attack("Slap", (level*2));
                return new BodyPart("beaver_tail", "tail", atk, level*2+3, beaverTail,
                        new Point (beaverTail.getWidth()* 0.7f, beaverTail.getHeight()* 1f/2));
            case "beaver_body":
                Image beaverBody = ResourceLoader.getImage("beaver_body");
                connectors = new BodyConnectors(
                        new Point(beaverBody.getWidth()*0.8f, (beaverBody.getHeight()*0.1f)),
                        new Point(beaverBody.getWidth()*0.9f, beaverBody.getHeight()*0.5f),
                        new Point(beaverBody.getWidth()*0.8f, beaverBody.getHeight()*0.4f),
                        new Point (beaverBody.getWidth()*0.1f, beaverBody.getHeight()*0.4f),
                        new Point (beaverBody.getWidth()*0.2f, beaverBody.getHeight()*0.4f),
                        new Point(-30, beaverBody.getHeight()*0.65f));
                return new BodyBodyPart("beaver_body", "body", null, level+6, beaverBody,null, connectors);

            case "ostrich_head":
                Image ostrichHead = ResourceLoader.getImage("ostrich_head");
                atk = new Attack("Peck", level*2 - 1);
                return new BodyPart("ostrich_head", "head", atk, level, ostrichHead,
                        new Point(0, ostrichHead.getHeight() - 20));
            case "ostrich_arm":
                Image ostrichArm = ResourceLoader.getImage("ostrich_arm");
                atk = new Attack("Flap", level);
                return new BodyPart("ostrich_arm", "arm", atk, level-2, ostrichArm,
                        new Point(ostrichArm.getWidth()*1/6, ostrichArm.getHeight()/2));
            case "ostrich_leg":
                Image ostrichLeg = ResourceLoader.getImage("ostrich_leg");
                atk = new Attack("Stomp", level*2 - 1);
                return new BodyPart("ostrich_leg", "leg", atk, level*2+4, ostrichLeg,
                        new Point(ostrichLeg.getWidth()*2/5, ostrichLeg.getHeight()*1/6));
            case "ostrich_tail":
                Image ostrichTail = ResourceLoader.getImage("ostrich_tail");
                atk = new Attack("Fan", level);
                return new BodyPart("ostrich_tail", "tail", atk, level+4, ostrichTail,
                        new Point(ostrichTail.getWidth()/2-5, ostrichTail.getHeight()-20));
            case "ostrich_body":
                Image ostrichBody = ResourceLoader.getImage("ostrich_body");
                connectors = new BodyConnectors(
                        new Point(ostrichBody.getWidth()-20, ostrichBody.getHeight()/10),
                        new Point(ostrichBody.getWidth()/4, ostrichBody.getHeight()/2),
                        new Point (ostrichBody.getWidth()/4-20, ostrichBody.getHeight()/2-20),
                        new Point(ostrichBody.getWidth()/3.5f, ostrichBody.getHeight()/2.5f),
                        new Point(ostrichBody.getWidth()/3.5f-20, ostrichBody.getHeight()/2.5f-20),
                        new Point(10, ostrichBody.getHeight()/3
                ));
                return new BodyBodyPart("ostrich_body", "body", null,level*2, ostrichBody, null, connectors);

            case "bull_head":
                Image bullHead = ResourceLoader.getImage("bull_head");
                atk = new Attack("CHARGE", (3*level+6)/2);
                return new BodyPart("bull_head", "head", atk, 2*level+10, bullHead,
                        new Point(5, bullHead.getHeight()*0.75f));
            case "burning_arm":
                Image burningArm = ResourceLoader.getImage("burning_arm");
                atk = new Attack("PUNCH", (3*level+6)/2);
                return new BodyPart("burning_arm", "arm", atk, level+5, burningArm,
                        new Point(burningArm.getWidth()*0.66f, 20));
            case "frozen_leg":
                Image frozenLeg = ResourceLoader.getImage("frozen_leg");
                atk = new Attack("KICK", 2*level+7);
                return new BodyPart("frozen_leg", "leg", atk, 3*level-3, frozenLeg,
                        new Point(frozenLeg.getWidth()/2, 30));
            case "golden_monkey_arm":
                Image goldenMonkeyArm = ResourceLoader.getImage("golden_monkey_arm");
                atk = new Attack("GRAB", level+7);
                return new BodyPart("golden_monkey_arm", "arm", atk, level+7, goldenMonkeyArm,
                        new Point(goldenMonkeyArm.getWidth()/2, 20));
                        */
       //     default:
       //         throw new SlickException("Not a valid animal part.");
       // }
    }
}
