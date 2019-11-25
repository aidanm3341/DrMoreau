package combat;

import combat.stats.Stat;
import combat.view.animation.AttackAnimationToLeft;
import data.Mob;

public class EnemyController implements MobController {

    private Mob mob;

    public EnemyController(Mob mob){
        this.mob = mob;
    }

    public void enter(CombatController ctrl) {
        ctrl.doAttack(new Ability("Basic Attack", 1, 1, ctrl.getMob().getStat(Stat.ATTACK_DMG),
                new AttackAnimationToLeft(ctrl.getView().getMobView().getAttributes())));
    }

    public Mob getMob(){
        return mob;
    }
}
