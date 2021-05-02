package navigation;

import data.mob.MobCombatData;
import data.bodyparts.IBodyPart;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import util.ResourceLoader;

import java.util.List;

public class Room {
    private int type;
    private Image navigationImage, navigationImageHover;
    private MobCombatData mobCombatData;
    private List<IBodyPart> rewards;

    public Room(int type, MobCombatData mobCombatData, Image navigationImage, List<IBodyPart> rewards) throws SlickException
    {
        this.type = type;
        this.mobCombatData = mobCombatData;
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

    public MobCombatData getMob() {
        return mobCombatData;
    }

    public List<IBodyPart> getRewards() {
        return rewards;
    }
}
