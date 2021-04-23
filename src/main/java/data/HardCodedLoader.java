package data;

import combat.abilities.AbilityFactory;
import combat.stats.Stat;
import combat.stats.Stats;
import combat.view.animation.AttackAnimation;
import data.bodyparts.BodyPart;
import data.framework.IBodyPart;
import data.framework.BodyPartLoader;
import data.mobs.Dog;
import data.mobs.MobParts;
import data.mobs.Rat;

import java.util.HashMap;
import java.util.Map;

public class HardCodedLoader implements BodyPartLoader {

    private final Map<String, IBodyPart> parts;

    public HardCodedLoader(){
        parts = new HashMap<>();
        MobParts dog = new Dog(), rat = new Rat();
        parts.putAll(dog.getParts());
        parts.putAll(rat.getParts());

        Stats stats = new Stats();
        stats.put(Stat.MAX_HP, 100f);
        stats.put(Stat.CURRENT_HP, stats.get(Stat.MAX_HP));
        stats.put(Stat.ATTACK_DMG, 20f);
        IBodyPart moreau = new BodyPart("Dr.Moreau", stats,
                new AbilityFactory(AttackAnimation.DIRECTION.LEFT).basicDamageAbility(),
                new HashMap<>());
        parts.put("Dr.Moreau", moreau);
    }

    public Map<String, IBodyPart> getBodyParts() {
        return parts;
    }
}
