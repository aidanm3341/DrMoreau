package combat;

import combat.abilities.Ability;
import combat.view.animation.AttackAnimation;
import data.bodyparts.IBodyPart;
import util.Pool;

import java.util.Collection;
import java.util.stream.Collectors;

public class RandomAbilityStrategy implements AbilityStrategy{

    private final Pool<Ability> abilityPool;

    public RandomAbilityStrategy(Collection<IBodyPart> parts){
        this.abilityPool = new Pool<>();
        this.abilityPool.addAll(
                parts.stream().map(IBodyPart::getAbility)
                        .filter(ability -> !ability.getName().equals("Null"))
                        .peek(ability -> ability.setAnimationDirection(AttackAnimation.DIRECTION.LEFT))
                        .collect(Collectors.toSet())
        );
    }

    @Override
    public Ability getNextAbility() {
        return abilityPool.get();
    }
}
