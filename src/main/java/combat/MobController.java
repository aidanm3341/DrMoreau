package combat;

import data.mob.MobCombatData;

public interface MobController {
    void attachController(CombatController ctrl);
    MobCombatData getMob();
}
