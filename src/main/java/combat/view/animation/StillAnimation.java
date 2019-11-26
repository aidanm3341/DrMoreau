package combat.view.animation;

public class StillAnimation implements Animation {

    private int duration, maxDuration;

    public StillAnimation(){
        duration = 0;
        maxDuration = 30;
    }

    public void update() {
        duration++;
    }

    public boolean isDone() {
        return duration > maxDuration;
    }

    public Animation clone() {
        return new StillAnimation();
    }
}
