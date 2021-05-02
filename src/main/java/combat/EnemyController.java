package combat;

import combat.abilities.AbilityFactory;
import combat.view.animation.AttackAnimation;
import combat.view.mobview.MobView;
import combat.view.mobview.MobViewBuilder;
import combat.view.mobview.PhysicalAttributes;
import data.bodyparts.IBodyPart;
import data.bodyparts.PartType;
import data.mob.MobCombatData;

public class EnemyController implements MobController {

    private AbilityFactory abilityFactory;
    private MobCombatData mobCombatData;
    private MobView mobView;

    public EnemyController(MobCombatData mobCombatData){
        this.mobCombatData = mobCombatData;
        this.abilityFactory = new AbilityFactory(AttackAnimation.DIRECTION.LEFT);
        createMobView();
    }

    public void attachController(CombatController ctrl) {
        ctrl.executeAbility(abilityFactory.summedDamage("Attack"));
    }

    private void createMobView(){
        IBodyPart body = mobCombatData.getPart(PartType.BODY);

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body, new PhysicalAttributes(1150, 400));
        for(PartType type : PartType.values()){
            if(type != PartType.BODY && mobCombatData.hasPart(type))
                mobViewBuilder.addPart(type, mobCombatData.getPart(type));
        }
        mobView = mobViewBuilder.finalise(true);
    }

    public MobCombatData getMobData(){
        return mobCombatData;
    }

    public MobView getMobView() {
        return mobView;
    }
}
