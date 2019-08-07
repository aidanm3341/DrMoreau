package upgrade.bodyparts;

import combat.Attack;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;

public interface AbstractBodyPart {

    String getName();
    String getType();
    int getHp();
    Point getAttachPoint();
    Image getImage();
    float getWidth();
    float getHeight();
    Attack getAttack();
    int getLevel();
}
