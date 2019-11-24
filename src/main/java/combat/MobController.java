package combat;

import data.Mob;

public interface MobController {
    void enter(CombatController ctrl);
    Mob getMob();
}
