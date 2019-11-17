package navigation;

import combat.Mob;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import data.framework.BodyPart;
import util.ResourceLoader;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int type;
    private Image navigationImage, navigationImageHover;
    private Mob mob;
    private List<BodyPart> rewards;

    public Room(int type, Mob mob, Image navigationImage, List<BodyPart> rewards) throws SlickException
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

    public List<BodyPart> getRewards() {
        return rewards;
    }
}
