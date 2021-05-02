package data.mobs;

import combat.abilities.AbilityFactory;
import combat.stats.Stat;
import combat.stats.Stats;
import combat.view.animation.AttackAnimation;
import data.bodyparts.BodyPart;
import data.framework.IBodyPart;
import data.framework.PartType;
import data.mob.MobCombatData;

import java.util.HashMap;
import java.util.Map;

public class DrMoreau implements IMob {

    @Override
    public MobCombatData getMobData() {
        Stats stats = new Stats();
        stats.put(Stat.MAX_HP, 100f);
        stats.put(Stat.CURRENT_HP, stats.get(Stat.MAX_HP));
        stats.put(Stat.ATTACK_DMG, 20f);
        IBodyPart moreau = new BodyPart("Dr.Moreau", stats,
                new AbilityFactory(AttackAnimation.DIRECTION.LEFT).summedDamage("Attack"),
                new HashMap<>());

        return new MobCombatData("Dr.Moreau", Map.of(
                PartType.BODY, moreau
        ));
    }
}
