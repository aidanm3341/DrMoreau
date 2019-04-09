package combat;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import upgrade.bodyparts.BodyBodyPart;
import upgrade.bodyparts.BodyConnectors;
import upgrade.bodyparts.BodyPart;
import upgrade.bodyparts.PartFactory;
import util.CreatureComposer;
import util.PositionedImage;
import util.ResourceLoader;
import util.SuperImage;

import java.util.ArrayList;
import java.util.HashMap;

public class MobData {

    private static HashMap<String, Mob> mobs;

    private static void loadMobs() {
        mobs = new HashMap<>();
        SuperImage test = new SuperImage();
        test.addImage(new PositionedImage(ResourceLoader.getImage("ostrich_head"), 10, 10));
        test.flipH(true);
        mobs.put("test", new Mob("Test",
                50, 50, 50,  new ArrayList<>(),
                test));
    }

//    public static Mob getMob(String name)
//    {
//        if (mobs == null)
//            loadMobs();
//
//        return mobs.get(name);
//    }

    public static Mob getMob(String name) throws SlickException
    {
        SuperImage image = new SuperImage();
        switch(name) {
            case "test":
                image.addImage(new PositionedImage(ResourceLoader.getImage("ostrich_head"), 10, 10));
                image.flipH(true);
                return new Mob("Test", 50, 50, 50, new ArrayList<>(), image);
            case "dog":
                return makeDog();
            case "rat":
                return makeRat();
            case "bunny":
                return makeBunny();
            case "penguin":
                return makePenguin();
            case  "lion":
                return makeLion();
            case  "elephant":
                return makeElephant();
            case "beaver":
                return makeBeaver();
        }
        return null;
    }

    private static Mob makeDog() throws SlickException
    {
        BodyPart body = PartFactory.getPart("dog_body");
        BodyConnectors connectors = new BodyConnectors(
                new Point(body.getWidth()*0.9f, (body.getHeight()*0.33f)),
                new Point(body.getWidth()*0.8f, body.getHeight()*0.4f),
                new Point(body.getWidth()*0.7f, body.getHeight()*0.3f),
                new Point (body.getWidth()*0.3f, body.getHeight()*0.3f),
                new Point (body.getWidth()*0.2f, body.getHeight()*0.2f),
                new Point(0, body.getHeight()*0.4f));

        SuperImage image = CreatureComposer.composeImage(connectors,
                PartFactory.getPart("dog_head"),
                PartFactory.getPart("dog_arm"),
                PartFactory.getPart("dog_arm"),
                PartFactory.getPart("dog_leg"),
                PartFactory.getPart("dog_leg"),
                PartFactory.getPart("dog_tail"),
                PartFactory.getPart("dog_body"));
        image.flipH(true);

        ArrayList<BodyPart> parts = new ArrayList<>();
        parts.add(PartFactory.getPart("dog_head"));
        parts.add(PartFactory.getPart("dog_arm"));
        parts.add(PartFactory.getPart("dog_arm"));
        parts.add(PartFactory.getPart("dog_leg"));
        parts.add(PartFactory.getPart("dog_leg"));
        parts.add(PartFactory.getPart("dog_tail"));
        parts.add(PartFactory.getPart("dog_body"));


        return new Mob("Dog", 20, 10, 5, parts, image);
    }

    private static Mob makeRat() throws SlickException
    {
        BodyPart body = PartFactory.getPart("rat_body");

        SuperImage image = CreatureComposer.composeImage(((BodyBodyPart) body).getConnectors(),
                PartFactory.getPart("rat_head"),
                PartFactory.getPart("rat_arm"),
                PartFactory.getPart("rat_arm"),
                PartFactory.getPart("rat_leg"),
                PartFactory.getPart("rat_leg"),
                PartFactory.getPart("rat_tail"),
                PartFactory.getPart("rat_body"));
        image.flipH(true);

        ArrayList<BodyPart> parts = new ArrayList<>();
        parts.add(PartFactory.getPart("rat_head"));
        parts.add(PartFactory.getPart("rat_arm"));
        parts.add(PartFactory.getPart("rat_arm"));
        parts.add(PartFactory.getPart("rat_leg"));
        parts.add(PartFactory.getPart("rat_leg"));
        parts.add(PartFactory.getPart("rat_tail"));
        parts.add(PartFactory.getPart("rat_body"));

        return new Mob("Rat", 10, 5, 5, parts, image);
    }

    private static Mob makeBunny() throws SlickException
    {
        BodyPart body = PartFactory.getPart("bunny_body");

        SuperImage image = CreatureComposer.composeImage(((BodyBodyPart) body).getConnectors(),
                PartFactory.getPart("bunny_head"),
                PartFactory.getPart("bunny_arm"),
                PartFactory.getPart("bunny_arm"),
                PartFactory.getPart("bunny_leg"),
                PartFactory.getPart("bunny_leg"),
                PartFactory.getPart("bunny_tail"),
                PartFactory.getPart("bunny_body"));
        image.flipH(true);

        ArrayList<BodyPart> parts = new ArrayList<>();
        parts.add(PartFactory.getPart("bunny_head"));
        parts.add(PartFactory.getPart("bunny_arm"));
        parts.add(PartFactory.getPart("bunny_arm"));
        parts.add(PartFactory.getPart("bunny_leg"));
        parts.add(PartFactory.getPart("bunny_leg"));
        parts.add(PartFactory.getPart("bunny_tail"));
        parts.add(PartFactory.getPart("bunny_body"));

        return new Mob("Bunny", 10, 5, 5, parts, image);
    }

    private static Mob makePenguin() throws SlickException
    {
        BodyPart body = PartFactory.getPart("penguin_body");

        SuperImage image = CreatureComposer.composeImage(((BodyBodyPart) body).getConnectors(),
                PartFactory.getPart("penguin_head"),
                PartFactory.getPart("penguin_arm"),
                PartFactory.getPart("penguin_arm"),
                PartFactory.getPart("penguin_leg"),
                PartFactory.getPart("penguin_leg"),
                PartFactory.getPart("penguin_tail"),
                PartFactory.getPart("penguin_body"));
        image.flipH(true);

        ArrayList<BodyPart> parts = new ArrayList<>();
        parts.add(PartFactory.getPart("penguin_head"));
        parts.add(PartFactory.getPart("penguin_arm"));
        parts.add(PartFactory.getPart("penguin_arm"));
        parts.add(PartFactory.getPart("penguin_leg"));
        parts.add(PartFactory.getPart("penguin_leg"));
        parts.add(PartFactory.getPart("penguin_tail"));
        parts.add(PartFactory.getPart("penguin_body"));

        return new Mob("Penguin", 10, 5, 5, parts, image);
    }

    private static Mob makeLion() throws SlickException
    {
        BodyPart body = PartFactory.getPart("lion_body");

        SuperImage image = CreatureComposer.composeImage(((BodyBodyPart) body).getConnectors(),
                PartFactory.getPart("lion_head"),
                PartFactory.getPart("lion_arm"),
                PartFactory.getPart("lion_arm"),
                PartFactory.getPart("lion_leg"),
                PartFactory.getPart("lion_leg"),
                PartFactory.getPart("dog_tail"),
                PartFactory.getPart("lion_body"));
        image.flipH(true);

        ArrayList<BodyPart> parts = new ArrayList<>();
        parts.add(PartFactory.getPart("lion_head"));
        parts.add(PartFactory.getPart("lion_arm"));
        parts.add(PartFactory.getPart("lion_arm"));
        parts.add(PartFactory.getPart("lion_leg"));
        parts.add(PartFactory.getPart("lion_leg"));
        parts.add(PartFactory.getPart("dog_tail"));
        parts.add(PartFactory.getPart("lion_body"));

        return new Mob("Lion", 10, 5, 5, parts, image);
    }
    private static Mob makeElephant() throws SlickException
    {
        BodyPart body = PartFactory.getPart("elephant_body");

        SuperImage image = CreatureComposer.composeImage(((BodyBodyPart) body).getConnectors(),
                PartFactory.getPart("elephant_head"),
                PartFactory.getPart("elephant_arm"),
                PartFactory.getPart("elephant_arm"),
                PartFactory.getPart("elephant_leg"),
                PartFactory.getPart("elephant_leg"),
                PartFactory.getPart("elephant_tail"),
                PartFactory.getPart("elephant_body"));
        image.flipH(true);

        ArrayList<BodyPart> parts = new ArrayList<>();
        parts.add(PartFactory.getPart("elephant_head"));
        parts.add(PartFactory.getPart("elephant_arm"));
        parts.add(PartFactory.getPart("elephant_arm"));
        parts.add(PartFactory.getPart("elephant_leg"));
        parts.add(PartFactory.getPart("elephant_leg"));
        parts.add(PartFactory.getPart("elephant_tail"));
        parts.add(PartFactory.getPart("elephant_body"));

        return new Mob("Elephant", 10, 5, 5, parts, image);
    }

    private static Mob makeBeaver() throws SlickException
    {
        BodyPart body = PartFactory.getPart("beaver_body");

        SuperImage image = CreatureComposer.composeImage(((BodyBodyPart) body).getConnectors(),
                PartFactory.getPart("beaver_head"),
                PartFactory.getPart("beaver_arm"),
                PartFactory.getPart("beaver_arm"),
                PartFactory.getPart("beaver_leg"),
                PartFactory.getPart("beaver_leg"),
                PartFactory.getPart("beaver_tail"),
                PartFactory.getPart("beaver_body"));
        image.flipH(true);

        ArrayList<BodyPart> parts = new ArrayList<>();
        parts.add(PartFactory.getPart("beaver_head"));
        parts.add(PartFactory.getPart("beaver_arm"));
        parts.add(PartFactory.getPart("beaver_arm"));
        parts.add(PartFactory.getPart("beaver_leg"));
        parts.add(PartFactory.getPart("beaver_leg"));
        parts.add(PartFactory.getPart("beaver_tail"));
        parts.add(PartFactory.getPart("beaver_body"));

        return new Mob("Beaver", 10, 5, 5, parts, image);
    }
}
