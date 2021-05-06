package data.mobs;

import combat.RandomAbilityStrategy;
import combat.abilities.AbilityFactory;
import combat.stats.Stat;
import combat.stats.Stats;
import combat.view.animation.AttackAnimation;
import data.bodyparts.BodyPart;
import data.bodyparts.IBodyPart;
import data.bodyparts.PartType;
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
        IBodyPart moreau = new BodyPart("DrMoreau_body", stats,
                new AbilityFactory(AttackAnimation.DIRECTION.LEFT).summedDamage("Attack"),
                new HashMap<>());

        Map<PartType, IBodyPart> parts = Map.of(
                PartType.BODY, moreau
        );
        return new MobCombatData("Dr.Moreau", parts, new RandomAbilityStrategy(parts.values()));
    }
}
