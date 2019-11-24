package combat.animation;

import combat.mobview.PhysicalAttributes;

public interface Animation extends Cloneable{
    void update();
    boolean isDone();
    Animation clone();
}
