package combat.abilities;


import combat.abilities.effects.Effect;
import combat.view.animation.Animation;
import combat.view.animation.AnimationManager;
import data.mob.MobCombatData;

import java.util.List;

public class Ability {

    private String name;
    private Animation animation;
    private List<Effect> effects;

    public Ability(String name, List<Effect> effects, Animation animation)
    {
        this.name = name;
        this.effects = effects;
        this.animation = animation;
    }

    public String getName(){
        return name;
    }

    public void execute(AnimationManager animationManager, MobCombatData attacker, MobCombatData defender){
        animationManager.doAnimation(animation.clone());
        for(Effect effect : effects)
            effect.attach(attacker, defender);
    }
}
