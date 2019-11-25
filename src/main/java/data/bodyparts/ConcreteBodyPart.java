package data.bodyparts;

import combat.Attack;
import combat.stats.Stats;
import data.framework.BodyPart;
import data.framework.PartType;
import org.newdawn.slick.Image;
import util.Point;
import util.ResourceLoader;

import java.util.Map;

public class ConcreteBodyPart implements BodyPart {

    private String name;
    private Image image;
    private Attack attack;
    private Stats stats;
    private Map<PartType, Point> attachPoints;

    public ConcreteBodyPart(String name, Stats stats, Map<PartType, Point> attachPoints)
    {
        this.name = name;
        this.stats = stats;
        this.image = ResourceLoader.getImage(name);
        this.attachPoints = attachPoints;
    }

    public String getName(){return name;}

    public Stats getStats() {
        return stats;
    }

    public Point getAttachPointFor(PartType type){
        return attachPoints.get(type);
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

    public BodyPart clone(){
        return new ConcreteBodyPart(name, stats, attachPoints);
    }
}
