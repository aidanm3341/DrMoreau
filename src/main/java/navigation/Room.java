package navigation;

import combat.Mob;
import main.Main;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import upgrade.bodyparts.BodyPart;
import util.ResourceLoader;

import java.util.ArrayList;

public class Room {

    public static final int BATTLE = Main.FIGHT, TREASURE = Main.UPGRADE;

    private int type;
    private String theme;
    private Image navigationImage, navigationImageHover;
    private Mob mob;
    private ArrayList<BodyPart> rewards;

    public Room(int type, String theme, Mob mob, Image navigationImage, ArrayList<BodyPart> rewards) throws SlickException
    {
        this.type = type;
        this.theme = theme;
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

    public String getTheme() {
        return theme;
    }

    public Mob getMob() {
        return mob;
    }

    public ArrayList<BodyPart> getRewards() {
        return rewards;
    }
}
