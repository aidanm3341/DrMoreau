package combat.abilities;

import combat.abilities.effects.ArmorEffect;
import combat.abilities.effects.FlatDamageEffect;
import combat.abilities.effects.SummedDamageEffect;
import combat.abilities.effects.IEffect;
import combat.view.animation.AttackAnimation;
import combat.view.animation.StillAnimation;

import java.util.List;

public class AbilityFactory {

    private final AttackAnimation.DIRECTION direction;

    public AbilityFactory(AttackAnimation.DIRECTION direction){
        this.direction = direction;
    }

    public Ability summedDamage(String name){
        List<IEffect> effects = List.of(
                new SummedDamageEffect()
        );
        return new Ability(name, effects, new AttackAnimation(direction));
    }

    public Ability basicDefend(String name, int armor){
        List<IEffect> effects = List.of(
                new ArmorEffect(armor)
        );
        return new Ability(name, effects, new StillAnimation());
    }

    public Ability nullAbility(){
        return new Ability("Null", List.of(), new StillAnimation());
    }

    public Ability flatDamage(String name, float damage){
        List<IEffect> effects = List.of(
                new FlatDamageEffect(damage)
        );
        return new Ability(name, effects, new AttackAnimation(direction));
    }

    public Ability armorAndDamage(String name, float damage, float armor){
        List<IEffect> effects = List.of(
                new FlatDamageEffect(damage),
                new ArmorEffect(armor)
        );
        return new Ability(name, effects, new AttackAnimation(direction));
    }
}
