package data.framework;

import combat.Attack;
import org.newdawn.slick.Image;
import util.Point;

import java.util.Map;

public interface BodyPart extends Cloneable {
    String getName();
    int getHp();
    Point getAttachPoint();
    Map<PartType, Point> getAttachPoints();
    Image getImage();
    void setImage(Image image);
    float getWidth();
    float getHeight();
    Attack getAttack();
    BodyPart clone();
}
