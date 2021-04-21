package data.bodyparts;

import combat.abilities.Ability;
import combat.stats.Stats;
import data.framework.IBodyPart;
import data.framework.PartType;
import org.newdawn.slick.Image;
import util.Point;
import util.ResourceLoader;

import java.util.Map;

public class BodyPart implements IBodyPart {

    private String name;
    private Image image;
    private Ability attack;
    private Stats stats;
    private Map<PartType, Point> attachPoints;

    public BodyPart(String name, Stats stats, Map<PartType, Point> attachPoints)
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

    public Ability getAttack() {
        return attack;
    }

    public IBodyPart clone(){
        return new BodyPart(name, stats, attachPoints);
    }
}
