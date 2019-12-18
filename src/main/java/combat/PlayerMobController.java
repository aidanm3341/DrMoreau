package combat;

import combat.abilities.Ability;
import data.mob.Mob;
import util.buttons.AbilityListener;

public class PlayerMobController implements MobController, AbilityListener {

    private CombatController ctrl;
    private Mob mob;

    public PlayerMobController(Mob mob){
        this.mob = mob;
    }

    public void enter(CombatController ctrl) {
        this.ctrl = ctrl;
    }

    public void movePerformed(Ability at) {
        ctrl.executeAbility(at);
    }

    public Mob getMob(){
        return mob;
    }
}
