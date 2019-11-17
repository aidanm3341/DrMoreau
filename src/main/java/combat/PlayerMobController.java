package combat;

import data.framework.MobController;
import util.buttons.MoveListener;

public class PlayerMobController implements MobController, MoveListener {

    private CombatController ctrl;

    public void enter(CombatController ctrl) {
        this.ctrl = ctrl;
    }

    public void movePerformed(Attack at) {
        ctrl.doAttack(at);
    }
}
