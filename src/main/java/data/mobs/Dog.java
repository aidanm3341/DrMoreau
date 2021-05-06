package data.mobs;

import combat.stats.Stats;
import data.bodyparts.IBodyPart;
import data.bodyparts.PartType;
import util.Point;

import java.util.Map;

public class Dog extends Mob {

    public Dog(String name, int level){
        super(name, level);
        System.out.println("Bark!");
    }

    public IBodyPart buildHead(){
        partBuilder.setName("dog_head");
        partBuilder.setStats(Stats.ofHealthAndDamage(level+3, level/2+2));
        partBuilder.setAbility(abilityFactory.flatDamage("Bite", level+6));
        partBuilder.addAttachPoint(PartType.BODY, new Point(0, 72));
        return partBuilder.finish();
    }

    public IBodyPart buildArms(){
        partBuilder.setName("dog_arm");
        partBuilder.setStats(Stats.ofHealthAndDamage(level/2+2, level-1));
        partBuilder.setAbility(abilityFactory.nullAbility());
        partBuilder.addAttachPoint(PartType.BODY, new Point(40, 20));
        return partBuilder.finish();
    }

    public IBodyPart buildLegs(){
        partBuilder.setName("dog_leg");
        partBuilder.setStats(Stats.ofHealthAndDamage(level-1,level));
        partBuilder.setAbility(abilityFactory.nullAbility());
        partBuilder.addAttachPoint(PartType.BODY, new Point(36, 15));
        return partBuilder.finish();
    }

    public IBodyPart buildTail(){
        partBuilder.setName("dog_tail");
        partBuilder.setStats(Stats.ofHealthAndDamage(level/2, level/2));
        partBuilder.setAbility(abilityFactory.flatDamage("Wag", level/2+1));
        partBuilder.addAttachPoint(PartType.BODY, new Point(79, 19));
        return partBuilder.finish();
    }

    public IBodyPart buildBody(){
        partBuilder.setName("dog_body");
        partBuilder.setStats(Stats.ofHealthAndDamage(level+10, 0));
        partBuilder.setAbility(abilityFactory.basicDefend("Body Block", level+5));
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
