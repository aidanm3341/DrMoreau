package combat;

import util.PositionedImage;
import util.ResourceLoader;
import util.SuperImage;

import java.util.ArrayList;
import java.util.HashMap;

public class MobData {

    private static HashMap<String, Mob> mobs;

    private static void loadMobs()
    {
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

    public static Mob getMob(String name)
    {
        if (name.equals("test")) {
            SuperImage test = new SuperImage();
            test.addImage(new PositionedImage(ResourceLoader.getImage("ostrich_head"), 10, 10));
            test.flipH(true);
            return new Mob("Test",
                    50, 50, 50,  new ArrayList<>(),
                    test);

        }
        return null;
    }
}
