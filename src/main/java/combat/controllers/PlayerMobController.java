package combat.controllers;

import combat.abilities.Ability;
import combat.view.animation.AttackAnimation;
import combat.view.mobview.MobView;
import combat.view.mobview.MobViewBuilder;
import data.bodyparts.IBodyPart;
import data.bodyparts.PartType;
import data.mob.MobCombatData;
import util.buttons.AbilityListener;

public class PlayerMobController implements MobController, AbilityListener {

    private CombatController ctrl;
    private MobCombatData mobCombatData;
    private MobView mobView;

    public PlayerMobController(MobCombatData mobCombatData){
        this.mobCombatData = mobCombatData;
        createPlayerView();
    }

    public void attachController(CombatController ctrl) {
        this.ctrl = ctrl;
    }

    public void movePerformed(Ability at) {
        at.setAnimationDirection(AttackAnimation.DIRECTION.RIGHT);
        ctrl.executeAbility(at);
    }

    private void createPlayerView(){
        IBodyPart body = mobCombatData.getPart(PartType.BODY);

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body);
        for(PartType type : PartType.values()){
            if(type != PartType.BODY)
                mobViewBuilder.addPart(type, mobCombatData.getPart(type));
        }
        mobView = mobViewBuilder.finalise(false);
        mobView.setXAndHomeX(400);
        mobView.setYandHomeY(380);
    }

    public MobView getMobView() {
        return mobView;
    }

    public MobCombatData getMobData(){
        return mobCombatData;
    }
}
