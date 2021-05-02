package data.mob;

import data.HardCodedLoader;
import data.framework.BodyPartLoader;
import org.newdawn.slick.SlickException;

public class MobCreator {

    private static final BodyPartLoader loader = new HardCodedLoader();

    public static MobCombatData getMob(String name, int level) throws SlickException {
        return loader.getMob(name, level);
    }
}
