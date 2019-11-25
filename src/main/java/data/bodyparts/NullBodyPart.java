package data.bodyparts;

import combat.Ability;
import combat.stats.Stats;
import data.framework.BodyPart;
import data.framework.PartType;
import org.newdawn.slick.Image;
import util.Point;
import util.ResourceLoader;

public class NullBodyPart implements BodyPart {

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

    public Ability getAttack() { return new Ability("Null", 0, 0,0, null); }

    public NullBodyPart clone(){
        return new NullBodyPart();
    }
}
