package combat.view.animation;

import combat.view.mobview.PhysicalAttributes;

public interface AnimationManager {
    void doAnimation(Animation animation);
    void update(PhysicalAttributes attacker, PhysicalAttributes defender);
    boolean isDone();
}
