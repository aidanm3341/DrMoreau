package combat;

import combat.abilities.Ability;
import combat.abilities.effects.DamageEffect;
import combat.abilities.effects.Effect;
import combat.stats.Stat;
import combat.view.animation.AttackAnimationToLeft;
import data.mob.Mob;

import java.util.ArrayList;
import java.util.List;

public class EnemyController implements MobController {

    private Mob mob;

    public EnemyController(Mob mob){
        this.mob = mob;
    }

    public void attachController(CombatController ctrl) {
        List<Effect> effects = new ArrayList<>();
        effects.add(new DamageEffect(ctrl.getMob().getStat(Stat.ATTACK_DMG)));
        ctrl.executeAbility(new Ability("Basic Attack", effects,
                new AttackAnimationToLeft(ctrl.getView().getMobView().getAttributes())));
    }

    public Mob getMob(){
        return mob;
    }
}
