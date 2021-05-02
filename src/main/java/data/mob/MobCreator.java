package data.mob;

import data.loaders.HardCodedLoader;
import data.loaders.BodyPartLoader;
import org.newdawn.slick.SlickException;

public class MobCreator {

    private static final BodyPartLoader loader = new HardCodedLoader();

    public static MobCombatData getMob(String name, int level) throws SlickException {
        return loader.getMob(name, level);
    }
}
