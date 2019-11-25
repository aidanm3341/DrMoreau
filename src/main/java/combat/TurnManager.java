package combat;

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

    public void attack(Ability atk){
        defender.getMob().attack(atk.getDmg());
        animationManager.doAnimation(atk.getAnimation());

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
    }
}
