package combat.view.animation;

import combat.view.mobview.PhysicalAttributes;

import java.util.ArrayList;
import java.util.List;

public class AnimationManagerImp implements AnimationManager {

    private List<Animation> animations;
    private List<Animation> animationsToBeRemoved;

    public AnimationManagerImp(){
        animations = new ArrayList<>();
        animationsToBeRemoved = new ArrayList<>();
    }

    public void doAnimation(Animation animation){
        animations.add(animation);
    }

    public void update(PhysicalAttributes attacker, PhysicalAttributes defender){
        for(Animation animation : animations) {
            animation.update(attacker, defender);
            if(animation.isDone())
                animationsToBeRemoved.add(animation);
        }

        for(Animation animationToBeRemoved : animationsToBeRemoved)
            animations.remove(animationToBeRemoved);
    }

    public boolean isDone(){
        return animations.isEmpty();
    }
}
