package upgrade.bodyparts;

import combat.Attack;
import data.framework.BodyPart;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;
import util.ResourceLoader;

public class ConcreteBodyPart implements BodyPart {

    private String name, type;
    private int hp;
    private Image image;
    private Attack attack;

    private Point attachPoint;
    private int level;

    public ConcreteBodyPart(String name, String type, Attack attack, int hp, Point attachPoint, int level)
    {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.hp = hp;
        this.image = ResourceLoader.getImage(name);
        this.attachPoint = attachPoint;
        this.level = level;
    }

    public String getName(){return name;}

    public String getType(){return type;}

    public int getHp(){return hp;}

    public Point getAttachPoint(){
        return attachPoint;
    }

    public Image getImage() {
        return image;
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

    public int getLevel(){
        return level;
    }
}
