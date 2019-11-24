package combat.animation;

import combat.mobview.PhysicalAttributes;

public class AttackAnimationToRight implements Animation {

    private PhysicalAttributes subject;
    private float rightPoint;
    private float initialX;

    private boolean phaseOneComplete, isDone;

    public AttackAnimationToRight(PhysicalAttributes subject){
        this.subject = subject;
        initialX = subject.x;
        rightPoint = initialX + 50;

        phaseOneComplete = false;
        isDone = false;
    }

    public void update() {
        if(subject.x < rightPoint && !phaseOneComplete)
            subject.x += 5;
        else if(subject.x >= rightPoint && !phaseOneComplete)
            phaseOneComplete = true;
        else if(phaseOneComplete && subject.x <= initialX)
            isDone = true;
        else if(phaseOneComplete)
            subject.x -= 4;
    }

    public boolean isDone() {
        return isDone;
    }

    public Animation clone(){
        return new AttackAnimationToRight(subject);
    }
}
