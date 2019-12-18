package combat;

import data.mob.Mob;

public interface MobController {
    void enter(CombatController ctrl);
    Mob getMob();
}
