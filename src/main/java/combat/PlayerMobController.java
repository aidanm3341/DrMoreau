package combat;

import combat.abilities.Ability;
import data.mob.MobCombatData;
import util.buttons.AbilityListener;

public class PlayerMobController implements MobController, AbilityListener {

    private CombatController ctrl;
    private MobCombatData mobCombatData;

    public PlayerMobController(MobCombatData mobCombatData){
        this.mobCombatData = mobCombatData;
    }

    public void attachController(CombatController ctrl) {
        this.ctrl = ctrl;
    }

    public void movePerformed(Ability at) {
        ctrl.executeAbility(at);
    }

    public MobCombatData getMob(){
        return mobCombatData;
    }
}
