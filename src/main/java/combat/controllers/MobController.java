package combat.controllers;

import combat.view.mobview.MobView;
import data.mob.MobCombatData;

public interface MobController {
    void attachController(CombatController ctrl);
    MobCombatData getMobData();
    MobView getMobView();
}
