package combat;

import combat.abilities.Ability;
import combat.view.animation.AnimationManager;

public class TurnManager {

    private CombatController controller;
    private AnimationManager animationManager;
    private MobController attacker, defender;

    private boolean isAttacking;

    public TurnManager(CombatController controller, AnimationManager animationManager,
                       MobController attacker, MobController defender){
        this.controller = controller;
        this.animationManager = animationManager;
        this.attacker = attacker;
        this.defender = defender;

        isAttacking = false;
    }

    public void executeAbility(Ability ability){
        if(!isAttacking)
            ability.execute(animationManager, attacker.getMob(), defender.getMob());

        isAttacking = true;
    }

    public void update(){
        animationManager.update();
        if(animationManager.isDone() && isAttacking){
            isAttacking = false;
            switchAttacker();
        }
    }

    private void switchAttacker(){
        MobController temp = defender;
        defender = attacker;
        attacker = temp;
        attacker.enter(controller);
        attacker.getMob().updateEffects();
    }
}
