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
                ResourceLoader.getImage("ostrich_head").getFlippedCopy(true, false).getScaledCopy(2f),
                50, new ArrayList<>()));
    }

    public static Mob getMob(String name)
    {
        if (mobs == null)
            loadMobs();

        return mobs.get(name);
    }
}
