package combat;

import combat.abilities.Ability;
import combat.controllers.CombatController;
import combat.controllers.MobController;
import combat.view.animation.AnimationManager;

public class TurnManager {

    private CombatController controller;
    private AnimationManager animationManager;
    private MobController attacker, defender;

    private boolean isAttacking, isPlayersTurn;

    public TurnManager(CombatController controller, AnimationManager animationManager,
                       MobController attacker, MobController defender){
        this.controller = controller;
        this.animationManager = animationManager;
        this.attacker = attacker;
        this.defender = defender;

        isAttacking = false;
        isPlayersTurn = true;
    }

    public void executeAbility(Ability ability){
        if(!isAttacking)
            ability.execute(animationManager, attacker.getMobData(), defender.getMobData());

        isAttacking = true;
    }

    public void update(){
        animationManager.update(attacker.getMobView().getAttributes(), defender.getMobView().getAttributes());

        if(animationManager.isDone() && isAttacking){
            isAttacking = false;
            switchAttacker();
        }
    }

    private void switchAttacker(){
        MobController temp = defender;
        defender = attacker;
        attacker = temp;
        attacker.attachController(controller);
        attacker.getMobData().updateEffects();

        isPlayersTurn = !isPlayersTurn;
    }
}
