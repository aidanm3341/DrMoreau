package data.mobs;

import data.mob.MobCombatData;

public interface IMob {
    //Map<String, IBodyPart> getParts();
    MobCombatData getMobData();
}
