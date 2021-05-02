package data.loaders;

import data.mob.MobCombatData;

public interface BodyPartLoader {
    MobCombatData getMob(String name, int level);
}
