package combat.view.animation;

import combat.view.mobview.PhysicalAttributes;

public interface Animation extends Cloneable{
    void update(PhysicalAttributes attacker, PhysicalAttributes defender);
    boolean isDone();
    AnimationState getState();
    Animation clone();
}
