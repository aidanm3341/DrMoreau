package data.mobs;

import combat.stats.Stats;
import data.bodyparts.IBodyPart;
import data.bodyparts.PartType;
import util.Point;

import java.util.Map;

public class Crocodile extends Mob{

    public Crocodile(int level) {
        super("Crocodile", level);
    }

    @Override
    public IBodyPart buildHead() {
        partBuilder.setName("crocodile_head");
        partBuilder.setStats(Stats.ofHealthAndDamage(2, 4));
        partBuilder.setAbility(abilityFactory.flatDamage("Snap", 20));
        partBuilder.addAttachPoint(PartType.BODY, new Point(15, 59));
        return partBuilder.finish();
    }

    @Override
    public IBodyPart buildArms() {
        partBuilder.setName("crocodile_arm");
        partBuilder.setStats(Stats.ofHealthAndDamage(1, 1));
        partBuilder.setAbility(abilityFactory.nullAbility());
        partBuilder.addAttachPoint(PartType.BODY, new Point(48, 22));
        return partBuilder.finish();
    }

    @Override
    public IBodyPart buildLegs() {
        partBuilder.setName("crocodile_leg");
        partBuilder.setStats(Stats.ofHealthAndDamage(2, 0));
        partBuilder.setAbility(abilityFactory.nullAbility());
        partBuilder.addAttachPoint(PartType.BODY, new Point(106, 19));
        return partBuilder.finish();
    }

    @Override
    public IBodyPart buildTail() {
        partBuilder.setName("crocodile_tail");
        partBuilder.setStats(Stats.ofHealthAndDamage(3, 4));
        partBuilder.setAbility(abilityFactory.flatDamage("Death Spin", 10));
        partBuilder.addAttachPoint(PartType.BODY, new Point(225, 40));
        return partBuilder.finish();
    }

    @Override
    public IBodyPart buildBody() {
        partBuilder.setName("crocodile_body");
        partBuilder.setStats(Stats.ofHealthAndDamage(10, 0));
        partBuilder.setAbility(abilityFactory.basicDefend("Tough Hide", 7));
        partBuilder.addAllAttachPoints(Map.of(
                PartType.HEAD,      new Point(257, 50),
                PartType.RIGHT_ARM, new Point(234, 66),
                PartType.LEFT_ARM,  new Point(222, 47),
                PartType.RIGHT_LEG, new Point(76, 73),
                PartType.LEFT_LEG,  new Point(90, 66),
                PartType.TAIL,      new Point(33, 63)
        ));
        return partBuilder.finish();
    }
}