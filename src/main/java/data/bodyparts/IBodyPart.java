package data.bodyparts;

import combat.abilities.Ability;
import combat.stats.Stats;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import util.Point;

public interface IBodyPart extends Cloneable {
    String getName();
    Stats getStats();
    Point getAttachPointFor(PartType type);
    Image getImage() throws SlickException;
    float getWidth();
    float getHeight();
    Ability getAbility();
    IBodyPart clone();
}
