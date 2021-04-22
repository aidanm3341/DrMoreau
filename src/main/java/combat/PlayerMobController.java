package combat;

import combat.abilities.Ability;
import combat.view.mobview.MobView;
import data.mob.MobCombatData;
import util.buttons.AbilityListener;

public class PlayerMobController implements MobController, AbilityListener {

    private CombatController ctrl;
    private MobCombatData mobCombatData;
    private MobView mobView;

    public PlayerMobController(MobCombatData mobCombatData, MobView mobView){
        this.mobCombatData = mobCombatData;
        this.mobView = mobView;
    }

    public void attachController(CombatController ctrl) {
        this.ctrl = ctrl;
    }

    public void movePerformed(Ability at) {
        ctrl.executeAbility(at);
    }

    public MobCombatData getMobData(){
        return mobCombatData;
    }

    public MobView getMobView() {
        return mobView;
    }
}
