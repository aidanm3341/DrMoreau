package data;

import combat.stats.Stat;
import combat.stats.Stats;
import data.bodyparts.BodyPart;
import data.framework.IBodyPart;
import data.framework.BodyPartLoader;
import data.framework.PartType;
import data.mobs.Dog;
import data.mobs.Rat;
import org.newdawn.slick.SlickException;
import util.Point;

import java.util.HashMap;
import java.util.Map;

public class HardCodedLoader implements BodyPartLoader {

    private Map<String, IBodyPart> parts;

    public HardCodedLoader(){
        parts = new HashMap<>();
        loadDogParts();
        loadRatParts();
    }

    public void loadDogParts(){
        Dog dog = new Dog();
        parts.putAll(dog.loadDogParts());
    }

    public void loadRatParts(){
        Rat rat = new Rat();
        parts.putAll(rat.loadRatParts());
    }

    public Map<String, IBodyPart> getBodyParts() {
        return parts;
    }
}
