package data.bodyparts;

import combat.abilities.Ability;
import combat.stats.Stats;
import data.framework.IBodyPart;
import data.framework.PartType;
import org.newdawn.slick.Image;
import util.Point;
import util.ResourceLoader;

import java.util.ArrayList;

public class NullBodyPart implements IBodyPart {

    public String getName() {
        return "";
    }

    @Override
    public Stats getStats() {
        return new Stats();
    }

    @Override
    public Point getAttachPointFor(PartType type) {
        return new Point(0, 0);
    }

    public Image getImage() {
        return ResourceLoader.getImage("null");
    }

    public float getWidth() {
        return 0;
    }

    public float getHeight() {
        return 0;
    }

    public Ability getAttack() { return new Ability("Null", new ArrayList<>(), null); }

    public NullBodyPart clone(){
        return new NullBodyPart();
    }
}
