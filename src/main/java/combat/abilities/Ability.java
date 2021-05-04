package combat.abilities;


import combat.abilities.effects.IEffect;
import combat.view.animation.Animation;
import combat.view.animation.AnimationManager;
import data.mob.MobCombatData;

import java.util.List;

public class Ability {

    private final String name;
    private final Animation animation;
    private final List<IEffect> effects;

    public Ability(String name, List<IEffect> effects, Animation animation) {
        this.name = name;
        this.effects = effects;
        this.animation = animation;
    }

    public String getName(){
        return name;
    }

    public void execute(AnimationManager animationManager, MobCombatData attacker, MobCombatData defender){
        animationManager.doAnimation(animation.clone());
        for(IEffect effect : effects)
            effect.attach(attacker, defender);
    }

    public String toString(){
        return effects.stream().map(IEffect::toString).reduce("", (acc, str) -> acc + str + "\n");
    }
}
