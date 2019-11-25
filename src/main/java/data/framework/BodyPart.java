package data.framework;

import combat.Attack;
import combat.stats.Stats;
import org.newdawn.slick.Image;
import util.Point;

import java.util.Map;

public interface BodyPart extends Cloneable {
    String getName();
    Stats getStats();
    Point getAttachPointFor(PartType type);
    Image getImage();
    float getWidth();
    float getHeight();
    Attack getAttack();
    BodyPart clone();
}
