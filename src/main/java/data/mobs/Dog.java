package data.mobs;

import combat.abilities.AbilityFactory;
import combat.stats.Stats;
import combat.view.animation.AttackAnimation;
import data.bodyparts.BodyPartBuilder;
import data.framework.IBodyPart;
import data.framework.PartType;
import util.Point;

import java.util.Map;

public class Dog implements MobParts{

    private static final String name = "dog";

    private final BodyPartBuilder partBuilder;
    private final AbilityFactory abilityFactory;

    public Dog(){
        this.partBuilder = new BodyPartBuilder();
        this.abilityFactory = new AbilityFactory(AttackAnimation.DIRECTION.RIGHT);
    }

    public Map<String, IBodyPart> getParts(){
//        MobPointGroup pointGroup = new MobPointGroup(
//                new Point(0, 72),
//                new Point(40, 20),
//                new Point(36, 15),
//                new Point(79, 19),
//                Map.of(
//                        PartType.HEAD,      new Point(220, 38),
//                        PartType.RIGHT_ARM, new Point(195, 47),
//                        PartType.LEFT_ARM,  new Point(171, 35),
//                        PartType.RIGHT_LEG, new Point(73, 35),
//                        PartType.LEFT_LEG,  new Point(49, 23),
//                        PartType.TAIL,      new Point(0, 46)
//                )
//        );
//
//        AnimalTemplate template = new AnimalTemplate(name, pointGroup);
//        return template.getPartsWithAttachPoints();
        return Map.of(
                "dog_head", buildHead(),
                "dog_arm", buildArms(),
                "dog_leg", buildLegs(),
                "dog_tail", buildTail(),
                "dog_body", buildBody()
        );
    }

    public IBodyPart buildHead(){
        partBuilder.setName("dog_head");
        partBuilder.setStats(Stats.ofHealthAndDamage(4, 2));
        partBuilder.setAbility(abilityFactory.flatDamageAbility("Bite", 10));
        partBuilder.addAttachPoint(PartType.BODY, new Point(0, 72));
        return partBuilder.finish();
    }

    public IBodyPart buildArms(){
        partBuilder.setName("dog_arm");
        partBuilder.setStats(Stats.ofHealthAndDamage(2, 2));
        partBuilder.setAbility(abilityFactory.nullAbility());
        partBuilder.addAttachPoint(PartType.BODY, new Point(40, 20));
        return partBuilder.finish();
    }

    public IBodyPart buildLegs(){
        partBuilder.setName("dog_leg");
        partBuilder.setStats(Stats.ofHealthAndDamage(3,1));
        partBuilder.setAbility(abilityFactory.nullAbility());
        partBuilder.addAttachPoint(PartType.BODY, new Point(36, 15));
        return partBuilder.finish();
    }

    public IBodyPart buildTail(){
        partBuilder.setName("dog_tail");
        partBuilder.setStats(Stats.ofHealthAndDamage(1, 1));
        partBuilder.setAbility(abilityFactory.flatDamageAbility("Wag", 2));
        partBuilder.addAttachPoint(PartType.BODY, new Point(79, 19));
        return partBuilder.finish();
    }

    public IBodyPart buildBody(){
        partBuilder.setName("dog_body");
        partBuilder.setStats(Stats.ofHealthAndDamage(10, 0));
        partBuilder.setAbility(abilityFactory.basicDefendAbility());
        partBuilder.addAllAttachPoints(Map.of(
                PartType.HEAD,      new Point(220, 38),
                PartType.RIGHT_ARM, new Point(195, 47),
                PartType.LEFT_ARM,  new Point(171, 35),
                PartType.RIGHT_LEG, new Point(73, 35),
                PartType.LEFT_LEG,  new Point(49, 23),
                PartType.TAIL,      new Point(0, 46)
        ));
        return partBuilder.finish();
    }
}
