package data.bodyparts;

import combat.abilities.Ability;
import combat.stats.Stats;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import util.Config;
import util.Point;
import util.ResourceLoader;

import java.util.Map;

public class BodyPart implements IBodyPart {

    private final String name;
    private final Image image;
    private final Ability ability;
    private final Stats stats;
    private final Map<PartType, Point> attachPoints;

    public BodyPart(String name, Stats stats, Ability ability, Map<PartType, Point> attachPoints) {
        this.name = name;
        this.stats = stats;
        this.ability = ability;

        String mobName = name.substring(0, name.indexOf('_'));
        Image partImage;
        try {
            partImage = new Image("parts/" + mobName + "/" + name + ".png");
        } catch (SlickException e) {
            partImage = null;
            e.printStackTrace();
        }
        this.image = partImage;
        this.attachPoints = attachPoints;
    }

    public String getName(){return name;}

    public Stats getStats() {
        return stats;
    }

    public Point getAttachPointFor(PartType type){
        return attachPoints.get(type);
    }

    public Image getImage() throws SlickException {
        if(Config.getInstance().isDebugMode()){
            Graphics g = image.getGraphics();
            attachPoints.values().forEach(p -> g.fillOval(p.x, p.y, 5, 5));
        }
        return image;
    }

    public float getWidth(){
        return image.getWidth();
    }

    public float getHeight(){
        return image.getHeight();
    }

    public Ability getAbility() {
        return ability;
    }

    public IBodyPart clone(){
        return new BodyPart(name, stats, ability, attachPoints);
    }
}
