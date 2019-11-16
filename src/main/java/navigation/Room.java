package navigation;

import combat.Mob;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import data.framework.BodyPart;
import util.ResourceLoader;

import java.util.ArrayList;

public class Room {
    private int type;
    private Image navigationImage, navigationImageHover;
    private Mob mob;
    private ArrayList<BodyPart> rewards;

    public Room(int type, Mob mob, Image navigationImage, ArrayList<BodyPart> rewards) throws SlickException
    {
        this.type = type;
        this.mob = mob;
        this.navigationImage = navigationImage;
        navigationImageHover = navigationImage.copy();
        navigationImageHover.getGraphics().drawImage(ResourceLoader.getImage("travelHover"), 0, 0);
        navigationImageHover.getGraphics().flush();
        this.rewards = rewards;
    }

    public int getType() {
        return type;
    }

    public Image getNavigationImage() {
        return navigationImage;
    }

    public Image getNavigationImageHover() {
        return navigationImageHover;
    }

    public Mob getMob() {
        return mob;
    }

    public ArrayList<BodyPart> getRewards() {
        return rewards;
    }
}
