package combat.view.animation;

import combat.view.mobview.PhysicalAttributes;

public class StillAnimation implements Animation {

    private int duration, maxDuration;
    private AnimationState state;

    public StillAnimation(int maxDuration){
        state = new AnimationState();
        duration = 0;
        this.maxDuration = maxDuration;
    }

    public void update(PhysicalAttributes attacker, PhysicalAttributes defender) {
        duration++;
    }

    public boolean isDone() {
        return duration > maxDuration;
    }

    public AnimationState getState() {
        return state;
    }

    @Override
    public void setDirection(AttackAnimation.DIRECTION direction) { }

    public Animation clone() {
        return new StillAnimation(maxDuration);
    }
}
