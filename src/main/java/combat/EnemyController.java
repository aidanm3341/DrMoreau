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

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body);
        for(PartType type : PartType.values()){
            if(type != PartType.BODY && mobCombatData.hasPart(type))
                mobViewBuilder.addPart(type, mobCombatData.getPart(type));
        }
        mobView = mobViewBuilder.finalise(true);
        mobView.setXAndHomeX(1400 - mobView.getBoundingRectangle().getWidth()/2);
        mobView.setYandHomeY(400);
    }

    public MobCombatData getMobData(){
        return mobCombatData;
    }

    public MobView getMobView() {
        return mobView;
    }
}
