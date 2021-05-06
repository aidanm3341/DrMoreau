package combat.view.animation;

import combat.view.mobview.PhysicalAttributes;

public class AttackAnimation implements Animation {

    public enum DIRECTION {LEFT, RIGHT};

    private float targetX;
    private float initialX;
    private AnimationState state;
    private DIRECTION direction;

    private boolean phaseOneComplete, isDone;

    public AttackAnimation(DIRECTION direction){
        this.direction = direction;
        state = new AnimationState();
        initialX = 0;
        targetX = direction == DIRECTION.LEFT ? -50 : 50;

        phaseOneComplete = false;
        isDone = false;
    }

    public void update(PhysicalAttributes attacker, PhysicalAttributes defender) {
        if(direction == DIRECTION.LEFT) {
            if (attacker.x > attacker.homeX + targetX && !phaseOneComplete)
                attacker.x -= 5;
            else if (attacker.x <= attacker.homeX + targetX && !phaseOneComplete)
                phaseOneComplete = true;
            else if (phaseOneComplete && attacker.x >= attacker.homeX)
                isDone = true;
            else if (phaseOneComplete)
                attacker.x += 4;
        }else if(direction == DIRECTION.RIGHT){
            if(attacker.x < attacker.homeX + targetX && !phaseOneComplete)
                attacker.x += 5;
            else if(attacker.x >= attacker.homeX + targetX && !phaseOneComplete)
                phaseOneComplete = true;
            else if(phaseOneComplete && attacker.x <= attacker.homeX)
                isDone = true;
            else if(phaseOneComplete)
                attacker.x -= 4;
        }
    }

    @Override
    public AnimationState getState() {
        return null;
    }

    @Override
    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }

    public boolean isDone() {
        return isDone;
    }

    public Animation clone(){
        return new AttackAnimation(direction);
    }
}
