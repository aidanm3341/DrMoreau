package combat.view.animation;

import combat.view.mobview.PhysicalAttributes;

public class StillAnimation implements Animation {

    private int duration, maxDuration;
    private AnimationState state;

    public StillAnimation(){
        state = new AnimationState();
        duration = 0;
        maxDuration = 30;
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

    public Animation clone() {
        return new StillAnimation();
    }
}
