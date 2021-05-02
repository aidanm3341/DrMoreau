package data.mobs;

import data.framework.IBodyPart;
import data.mob.MobCombatData;

import java.util.Map;

public interface IMob {
    //Map<String, IBodyPart> getParts();
    MobCombatData getMobData();
}
