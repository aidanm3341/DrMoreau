package data;

import data.framework.BodyPartLoader;
import data.mob.MobCombatData;
import data.mobs.Dog;
import data.mobs.DrMoreau;
import data.mobs.Rat;


public class HardCodedLoader implements BodyPartLoader {

    @Override
    public MobCombatData getMob(String name, int level) {
        return switch (name) {
            case "sidekick"  -> new Dog("sidekick", level).getMobData();
            case "dog"       -> new Dog("dog", level).getMobData();
            case "rat"       -> new Rat(level).getMobData();
            case "Dr.Moreau" -> new DrMoreau().getMobData();
            default          -> null;
        };
    }
}
