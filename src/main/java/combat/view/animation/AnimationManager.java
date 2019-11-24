package combat.view.animation;

public interface AnimationManager {
    void doAnimation(Animation animation);
    void update();
    boolean isDone();
}
