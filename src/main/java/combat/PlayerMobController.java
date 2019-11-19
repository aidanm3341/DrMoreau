package combat;

import data.framework.MobController;
import util.buttons.AbilityListener;

public class PlayerMobController implements MobController, AbilityListener {

    private CombatController ctrl;

    public void enter(CombatController ctrl) {
        this.ctrl = ctrl;
    }

    public void movePerformed(Attack at) {
        ctrl.doAttack(at);
    }
}
