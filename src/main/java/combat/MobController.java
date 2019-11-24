package combat;

import combat.CombatController;
import data.Mob;

public interface MobController {
    void enter(CombatController ctrl);
    Mob getMob();
}
