package combat.view.animation;

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

    public void update(){
        for(Animation animation : animations) {
            animation.update();
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
