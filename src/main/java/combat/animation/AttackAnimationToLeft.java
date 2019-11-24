package combat.animation;

import combat.mobview.PhysicalAttributes;

public class AttackAnimationToLeft implements Animation {

    private PhysicalAttributes subject;
    private float leftPoint;
    private float initialX;

    private boolean phaseOneComplete, isDone;

    public AttackAnimationToLeft(PhysicalAttributes subject){
        this.subject = subject;
        initialX = subject.x;
        leftPoint = initialX - 50;

        phaseOneComplete = false;
        isDone = false;
    }

    public void update() {
        if(subject.x > leftPoint && !phaseOneComplete)
            subject.x -= 5;
        else if(subject.x <= leftPoint && !phaseOneComplete)
            phaseOneComplete = true;
        else if(phaseOneComplete && subject.x >= initialX)
            isDone = true;
        else if(phaseOneComplete)
            subject.x += 4;
    }

    public boolean isDone() {
        return isDone;
    }

    public Animation clone(){
        return new AttackAnimationToLeft(subject);
    }
}
