package upgrade.bodyparts;

import combat.Attack;
import data.framework.BodyPart;
import data.framework.PartType;
import org.newdawn.slick.Image;
import util.Point;
import util.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

public class NullBodyPart implements BodyPart {

    public String getName() {
        return "";
    }

    public String getType() {
        return "";
    }

    public int getHp() {
        return 0;
    }

    public Point getAttachPoint() {
        return new Point(0,0);
    }

    public Map<PartType, Point> getAttachPoints() {
        return new HashMap<>();
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

    public Attack getAttack() { return new Attack("Null", 0,0); }

    public int getLevel() { return 0; }

    public NullBodyPart clone(){
        return new NullBodyPart();
    }
}
