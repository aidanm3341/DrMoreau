package data.mobs;

import combat.stats.Stats;
import data.bodyparts.IBodyPart;
import data.bodyparts.PartType;
import util.Point;

import java.util.Map;

public class Rat extends Mob {

    public Rat(int level){
        super("rat", level);
    }

    @Override
    public IBodyPart buildHead() {
        partBuilder.setName("rat_head");
        partBuilder.setStats(Stats.ofHealthAndDamage(level/2+4, level));
        partBuilder.setAbility(abilityFactory.poisonEffect("Infected Nibble", level/4+1, 3));
        partBuilder.addAttachPoint(PartType.BODY, new Point(20, 70));
        return partBuilder.finish();
    }

    @Override
    public IBodyPart buildArms() {
        partBuilder.setName("rat_arm");
        partBuilder.setStats(Stats.ofHealthAndDamage(level/3, level-1));
        partBuilder.setAbility(abilityFactory.nullAbility());
        partBuilder.addAttachPoint(PartType.BODY, new Point(36, 20));
        return partBuilder.finish();
    }

    @Override
    public IBodyPart buildLegs() {
        partBuilder.setName("rat_leg");
        partBuilder.setStats(Stats.ofHealthAndDamage(level, level/2-1));
        partBuilder.setAbility(abilityFactory.nullAbility());
        partBuilder.addAttachPoint(PartType.BODY, new Point(43, 20));
        return partBuilder.finish();
    }

    @Override
    public IBodyPart buildTail() {
        partBuilder.setName("rat_tail");
        partBuilder.setStats(Stats.ofHealthAndDamage(3, level/2));
        partBuilder.setAbility(abilityFactory.flatDamage("Tail Whip", level/2+3));
        partBuilder.addAttachPoint(PartType.BODY, new Point(85, 20));
        return partBuilder.finish();
    }

    @Override
    public IBodyPart buildBody() {
        partBuilder.setName("rat_body");
        partBuilder.setStats(Stats.ofHealthAndDamage(level+4, 0));
        partBuilder.setAbility(abilityFactory.basicDefend("Block", level+2));
        partBuilder.addAllAttachPoints(Map.of(
                PartType.HEAD, new Point(238, 98),
                PartType.RIGHT_ARM, new Point(200, 84),
                PartType.LEFT_ARM, new Point(175, 72),
                PartType.RIGHT_LEG, new Point(75, 84),
                PartType.LEFT_LEG, new Point(50, 72),
                PartType.TAIL, new Point(-10, 78)
        ));
        return partBuilder.finish();
    }
}
