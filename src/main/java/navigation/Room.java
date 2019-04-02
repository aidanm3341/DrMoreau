package navigation;

import combat.Mob;
import main.Main;
import org.newdawn.slick.Image;
import upgrade.bodyparts.BodyPart;
import util.ResourceLoader;

import java.util.ArrayList;

public class Room {

    public static final int BATTLE = Main.FIGHT, TREASURE = Main.UPGRADE;

    private int type;
    private String theme;
    private Image navigationImage;
    private Mob mob;
    private ArrayList<BodyPart> rewards;

    public Room(int type, String theme, Mob mob, Image navigationImage, ArrayList<BodyPart> rewards)
    {
        this.type = type;
        this.theme = theme;
        this.mob = mob;
        this.navigationImage = navigationImage;
        rewards = rewards;
    }

    public int getType() {
        return type;
    }

    public Image getNavigationImage() {
        return navigationImage;
    }
}
