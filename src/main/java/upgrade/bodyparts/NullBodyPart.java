package upgrade.bodyparts;

import main.Attack;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;
import upgrade.bodyparts.AbstractBodyPart;
import util.ResourceLoader;

public class NullBodyPart implements AbstractBodyPart {

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

    public Image getImage() {
        return ResourceLoader.getImage("null");
    }

    public float getWidth() {
        return 0;
    }

    public float getHeight() {
        return 0;
    }

    @Override
    public Attack getAttack() { return new Attack("Null", 0); }
}
