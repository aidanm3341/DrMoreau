package combat;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
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
        BodyPart body = PartFactory.getPart("dog_body");
        BodyConnectors connectors = new BodyConnectors(
                new Point(body.getWidth()*0.95f, (body.getHeight()*0.8f)),
                new Point(body.getWidth()*0.8f, body.getHeight()*0.7f),
                new Point(body.getWidth()*0.7f, body.getHeight()*0.6f),
                new Point (body.getWidth()*0.3f, body.getHeight()*0.7f),
                new Point (body.getWidth()*0.2f, body.getHeight()*0.6f),
                new Point(-10, body.getHeight()*0.65f));

        SuperImage image = CreatureComposer.composeImage(connectors,
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
}
