package combat;

import combat.animation.AnimationManager;
import combat.animation.AttackAnimationToLeft;
import combat.animation.AttackAnimationToRight;
import combat.stats.Stat;

public class AttackManager {

    private CombatController controller;
    private AnimationManager animationManager;

    private boolean isAttacking;

    public AttackManager(CombatController controller, AnimationManager animationManager){
        this.controller = controller;
        this.animationManager = animationManager;
        isAttacking = false;
    }

    public void attack(Attack atk){
        attack1(atk);
        isAttacking = true;
        animationManager.doAnimation(new AttackAnimationToRight(controller.getView().getPlayerView().getAttributes()));
    }

    public void update(){
        animationManager.update();
        if(animationManager.isDone() && isAttacking){
            attack2();
            animationManager.doAnimation(new AttackAnimationToLeft(controller.getView().getMobView().getAttributes()));
            isAttacking = false;
        }
    }

    private void attack1(Attack atk){
        controller.getMob().attack(atk.getDmg());
    }

    private void attack2(){
        controller.getSidekick().attack(controller.getMob().getStat(Stat.ATTACK_DMG));
    }
}
