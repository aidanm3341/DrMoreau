package data.mobs;

import combat.abilities.AbilityFactory;
import combat.view.animation.AttackAnimation;
import data.bodyparts.BodyPartBuilder;
import data.framework.IBodyPart;

import java.util.Map;

public abstract class MobParts implements IMobParts{

    private final String name;

    protected final BodyPartBuilder partBuilder;
    protected final AbilityFactory abilityFactory;

    protected MobParts(String name) {
        this.name = name;
        this.partBuilder = new BodyPartBuilder();
        this.abilityFactory = new AbilityFactory(AttackAnimation.DIRECTION.RIGHT);
    }

    @Override
    public Map<String, IBodyPart> getParts() {
        return Map.of(
                name + "_head", buildHead(),
                name + "_arm", buildArms(),
                name + "_leg", buildLegs(),
                name + "_tail", buildTail(),
                name + "_body", buildBody()
        );
    }

    public abstract IBodyPart buildHead();
    public abstract IBodyPart buildArms();
    public abstract IBodyPart buildLegs();
    public abstract IBodyPart buildTail();
    public abstract IBodyPart buildBody();
}
