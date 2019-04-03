package combat;

import util.ResourceLoader;

import java.util.ArrayList;
import java.util.HashMap;

public class MobData {

    private static HashMap<String, Mob> mobs;

    private static void loadMobs()
    {
        mobs = new HashMap<>();
        mobs.put("test", new Mob("Test",
                50, 50, 50,  new ArrayList<>(),
                ResourceLoader.getImage("ostrich_head").getFlippedCopy(true, false).getScaledCopy(2f)));
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
        if (name.equals("test"))
            return new Mob("Test",
                    50, 50, 50,  new ArrayList<>(),
                    ResourceLoader.getImage("ostrich_head").getFlippedCopy(true, false).getScaledCopy(2f));
        return null;
    }
}
