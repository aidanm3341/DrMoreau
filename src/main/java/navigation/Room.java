package navigation;

import combat.Mob;
import combat.MobData;
import main.Main;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import upgrade.bodyparts.AbstractBodyPart;
import upgrade.bodyparts.BodyPart;
import util.ResourceLoader;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int type;
    private Image navigationImage, navigationImageHover;
    private Mob mob;
    private ArrayList<AbstractBodyPart> rewards;

    public Room(int type, Mob mob, Image navigationImage, ArrayList<AbstractBodyPart> rewards) throws SlickException
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

    public ArrayList<AbstractBodyPart> getRewards() {
        return rewards;
    }
}
