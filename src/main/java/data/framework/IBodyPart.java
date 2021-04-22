package data.framework;

import combat.abilities.Ability;
import combat.stats.Stats;
import org.newdawn.slick.Image;
import util.Point;

public interface IBodyPart extends Cloneable {
    String getName();
    Stats getStats();
    Point getAttachPointFor(PartType type);
    Image getImage();
    float getWidth();
    float getHeight();
    Ability getAbility();
    IBodyPart clone();
}
