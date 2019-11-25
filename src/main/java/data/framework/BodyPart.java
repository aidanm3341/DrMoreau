package data.framework;

import combat.Ability;
import combat.stats.Stats;
import org.newdawn.slick.Image;
import util.Point;

public interface BodyPart extends Cloneable {
    String getName();
    Stats getStats();
    Point getAttachPointFor(PartType type);
    Image getImage();
    float getWidth();
    float getHeight();
    Ability getAttack();
    BodyPart clone();
}
