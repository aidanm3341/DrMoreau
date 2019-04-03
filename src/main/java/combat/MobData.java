package combat;

import org.newdawn.slick.SlickException;
import upgrade.bodyparts.BodyConnectors;
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
                image = CreatureComposer.composeImage(new BodyConnectors(PartFactory.getPart("dog_body")),
                        PartFactory.getPart("dog_head"),
                        PartFactory.getPart("dog_arm"),
                        PartFactory.getPart("dog_arm"),
                        PartFactory.getPart("dog_leg"),
                        PartFactory.getPart("dog_leg"),
                        PartFactory.getPart("dog_tail"),
                        PartFactory.getPart("dog_body"));
                image.flipH(true);
                return new Mob("Dog", 20, 10, 5, new ArrayList<>(), image);
            case "rat":
                image = CreatureComposer.composeImage(new BodyConnectors(PartFactory.getPart("rat_body")),
                        PartFactory.getPart("rat_head"),
                        PartFactory.getPart("rat_arm"),
                        PartFactory.getPart("rat_arm"),
                        PartFactory.getPart("rat_leg"),
                        PartFactory.getPart("rat_leg"),
                        PartFactory.getPart("rat_tail"),
                        PartFactory.getPart("rat_body"));
                image.flipH(true);
                return new Mob("Rat", 10, 5, 5, new ArrayList<>(), image);
        }
        return null;
    }
}
