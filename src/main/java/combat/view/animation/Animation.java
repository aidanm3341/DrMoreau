package combat.view.animation;

public interface Animation extends Cloneable{
    void update();
    boolean isDone();
    Animation clone();
}
