package combat;

import combat.abilities.Ability;
import combat.view.mobview.MobView;
import combat.view.mobview.MobViewBuilder;
import combat.view.mobview.PhysicalAttributes;
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
        ctrl.executeAbility(at);
    }

    private void createPlayerView(){
        IBodyPart body = mobCombatData.getPart(PartType.BODY);

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body, new PhysicalAttributes(400, 380));
        for(PartType type : PartType.values()){
            if(type != PartType.BODY)
                mobViewBuilder.addPart(type, mobCombatData.getPart(type));
        }
        mobView = mobViewBuilder.finalise(false);
    }

    public MobView getMobView() {
        return mobView;
    }

    public MobCombatData getMobData(){
        return mobCombatData;
    }
}
