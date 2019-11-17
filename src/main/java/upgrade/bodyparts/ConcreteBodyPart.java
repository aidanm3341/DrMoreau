package upgrade.bodyparts;

import combat.Attack;
import data.framework.BodyPart;
import data.framework.PartType;
import org.newdawn.slick.Image;
import util.Point;
import util.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

public class ConcreteBodyPart implements BodyPart {

    protected String name;
    protected int hp;
    protected Image image;
    protected Attack attack;

    protected Point attachPoint;
    protected int level;

    public ConcreteBodyPart(String name, Attack attack, int hp, Point attachPoint, int level)
    {
        this.name = name;
        this.attack = attack;
        this.hp = hp;
        this.image = ResourceLoader.getImage(name);
        this.attachPoint = attachPoint;
        this.level = level;
    }

    public String getName(){return name;}

    public int getHp(){return hp;}

    public Point getAttachPoint(){
        return attachPoint;
    }

    public Map<PartType, Point> getAttachPoints() {
        Map<PartType, Point> map = new HashMap<>();
        map.put(PartType.BODY, attachPoint);
        return map;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image){
        this.image = image;
    }

    public float getWidth(){
        return image.getWidth();
    }

    public float getHeight(){
        return image.getHeight();
    }

    public Attack getAttack() {
        return attack;
    }

    public BodyPart clone(){
        return new ConcreteBodyPart(name, attack, hp, attachPoint, level);
    }
}
