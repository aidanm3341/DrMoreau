package combat;

import combat.abilities.Ability;
import combat.abilities.effects.DamageEffect;
import combat.abilities.effects.Effect;
import combat.stats.Stat;
import combat.view.animation.AttackAnimationToLeft;
import data.mob.MobCombatData;

import java.util.ArrayList;
import java.util.List;

public class EnemyController implements MobController {

    private MobCombatData mobCombatData;

    public EnemyController(MobCombatData mobCombatData){
        this.mobCombatData = mobCombatData;
    }

    public void attachController(CombatController ctrl) {
        List<Effect> effects = new ArrayList<>();
        effects.add(new DamageEffect(ctrl.getMob().getStat(Stat.ATTACK_DMG)));
        ctrl.executeAbility(new Ability("Basic Attack", effects,
                new AttackAnimationToLeft(ctrl.getView().getMobView().getAttributes())));
    }

    public MobCombatData getMob(){
        return mobCombatData;
    }
}
