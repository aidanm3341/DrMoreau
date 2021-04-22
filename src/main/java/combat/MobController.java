package combat;

import data.mob.Mob;

public interface MobController {
    void attachController(CombatController ctrl);
    Mob getMob();
}
