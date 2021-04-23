package combat.abilities;

import combat.abilities.effects.ArmorEffect;
import combat.abilities.effects.DamageEffect;
import combat.abilities.effects.Effect;
import combat.view.animation.AttackAnimation;
import combat.view.animation.StillAnimation;

import java.util.ArrayList;
import java.util.List;

public class AbilityFactory {

    private AttackAnimation.DIRECTION direction;

    public AbilityFactory(AttackAnimation.DIRECTION direction){
        this.direction = direction;
    }

    public Ability basicDamageAbility(){
        List<Effect> effects = List.of(
                new DamageEffect()
        );
        return new Ability("Basic Attack", effects, new AttackAnimation(direction));
    }

    public Ability basicDefendAbility(){
        List<Effect> effects = List.of(
                new ArmorEffect(5, 0)
        );
        return new Ability("Basic Defend", effects, new StillAnimation());
    }
}
