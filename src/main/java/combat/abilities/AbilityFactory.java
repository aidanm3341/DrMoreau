package combat.abilities;

import combat.abilities.effects.ArmorEffect;
import combat.abilities.effects.FlatDamageEffect;
import combat.abilities.effects.SummedDamageEffect;
import combat.abilities.effects.Effect;
import combat.view.animation.AttackAnimation;
import combat.view.animation.StillAnimation;

import java.util.List;

public class AbilityFactory {

    private final AttackAnimation.DIRECTION direction;

    public AbilityFactory(AttackAnimation.DIRECTION direction){
        this.direction = direction;
    }

    public Ability basicDamageAbility(){
        List<Effect> effects = List.of(
                new SummedDamageEffect()
        );
        return new Ability("Basic Attack", effects, new AttackAnimation(direction));
    }

    public Ability basicDefendAbility(){
        List<Effect> effects = List.of(
                new ArmorEffect(5, 0)
        );
        return new Ability("Basic Defend", effects, new StillAnimation());
    }

    public Ability nullAbility(){
        return new Ability("Null", List.of(), new StillAnimation());
    }

    public Ability flatDamageAbility(String name, float damage){
        List<Effect> effects = List.of(
                new FlatDamageEffect(damage)
        );
        return new Ability(name, effects, new AttackAnimation(direction));
    }
}
