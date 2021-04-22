package data;

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
    }

    public Map<String, IBodyPart> getBodyParts() {
        return parts;
    }
}
