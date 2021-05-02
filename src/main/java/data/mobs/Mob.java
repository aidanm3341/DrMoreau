package data.mobs;

import combat.abilities.AbilityFactory;
import combat.view.animation.AttackAnimation;
import data.bodyparts.BodyPartBuilder;
import data.framework.IBodyPart;
import data.framework.PartType;
import data.mob.MobCombatData;

import java.util.HashMap;
import java.util.Map;

public abstract class Mob implements IMob {

    private final String name;
    protected final int level;

    protected final BodyPartBuilder partBuilder;
    protected final AbilityFactory abilityFactory;

    protected Mob(String name, int level) {
        this.name = name;
        this.level = level;
        this.partBuilder = new BodyPartBuilder();
        this.abilityFactory = new AbilityFactory(AttackAnimation.DIRECTION.RIGHT);
    }

    public MobCombatData getMobData() {
        return new MobCombatData(name, getParts());
    }

    public Map<PartType, IBodyPart> getParts() {
        IBodyPart arm = buildArms();
        IBodyPart leg = buildLegs();
        Map<PartType, IBodyPart> parts = new HashMap<>();
        parts.put(PartType.HEAD, buildHead());
        parts.put(PartType.LEFT_ARM, arm);
        parts.put(PartType.RIGHT_ARM, arm.clone());
        parts.put(PartType.LEFT_LEG, leg);
        parts.put(PartType.RIGHT_LEG, leg.clone());
        parts.put(PartType.TAIL, buildTail());
        parts.put(PartType.BODY, buildBody());

        return parts;
    }

    public abstract IBodyPart buildHead();
    public abstract IBodyPart buildArms();
    public abstract IBodyPart buildLegs();
    public abstract IBodyPart buildTail();
    public abstract IBodyPart buildBody();
}
